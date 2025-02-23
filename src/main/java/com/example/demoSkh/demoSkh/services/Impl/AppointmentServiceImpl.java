package com.example.demoSkh.demoSkh.services.Impl;

import com.example.demoSkh.demoSkh.model.Appointment;
import com.example.demoSkh.demoSkh.repository.AppointmentRepository;
import com.example.demoSkh.demoSkh.repository.DoctorRepository;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public Mono<Appointment> save(Appointment appointment) {
        Mono<Void>  t = throwIfDoctorIdIsInvalid(appointment.getDoctorId());
        Mono<Void> k = throwIfPatientIdIsInvalid(appointment.getPatientId());
        return t.mergeWith(k).then(appointmentRepository.save(appointment));
    }

    @Override
    public Mono<Appointment> update(Appointment appointment, Long id) {
        return throwIfDoctorIdIsInvalid(appointment.getDoctorId())
                .then(throwIfPatientIdIsInvalid(appointment.getPatientId()))
                .then(appointmentRepository.findById(id)
                        .flatMap(ele -> {
                            ele.setDoctorId(appointment.getDoctorId());
                            ele.setPatientId(appointment.getPatientId());
                            ele.setDetails(appointment.getDetails());
                            return appointmentRepository.save(ele); // Fix: save in the correct repository
                        })
                );
    };

    @Override
    public Mono<Void> delete(Long id) {
        return appointmentRepository.deleteById(id);
    }

    @Override
    public Flux<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Mono<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Flux<Appointment> findByDoctorId(Long id) {
        return appointmentRepository.findByDoctorId(id);
    }

    private Mono<Void> throwIfDoctorIdIsInvalid(Long id) {
        if (id == null) {
            return Mono.error(new IllegalArgumentException("Doctor id cannot be null"));
        }

        return doctorRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Doctor not found with id: " + id)))
                .then();
    }

    private Mono<Void> throwIfPatientIdIsInvalid(Long id) {
        if (id == null) {
            return Mono.error(new IllegalArgumentException("Patient id cannot be null"));
        }

        return patientRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Patient not found with id: " + id)))
                .then();
    }
}
