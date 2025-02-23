package com.example.demoSkh.demoSkh.services.Impl;

import com.example.demoSkh.demoSkh.dto.AppointmentDto;
import com.example.demoSkh.demoSkh.model.Appointment;
import com.example.demoSkh.demoSkh.repository.AppointmentRepository;
import com.example.demoSkh.demoSkh.repository.DoctorRepository;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Override
    public Mono<AppointmentDto> save(AppointmentDto appointmentDto) {
        return Mono.when(
                        throwIfDoctorIdIsInvalid(appointmentDto.getDoctorId()),
                        throwIfPatientIdIsInvalid(appointmentDto.getPatientId())
                )
                .then(Mono.defer(() -> {
                    // db interaction with -->>
                    Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
                    return appointmentRepository.save(appointment);
                }))
                .map(savedAppointment -> modelMapper.map(savedAppointment, AppointmentDto.class)); // Convert back to DTO
    }


    @Override
    public Mono<AppointmentDto> update(AppointmentDto appointmentDto, Long id) {
        return throwIfDoctorIdIsInvalid(appointmentDto.getDoctorId())
                .then(throwIfPatientIdIsInvalid(appointmentDto.getPatientId()))
                .then(appointmentRepository.findById(id)
                        .flatMap(ele -> {
                            ele.setDoctorId(appointmentDto.getDoctorId());
                            ele.setPatientId(appointmentDto.getPatientId());
                            ele.setDetails(appointmentDto.getDetails());
                            return appointmentRepository.save(ele).map(a-> modelMapper.map(a, AppointmentDto.class)); // Fix: save in the correct repository
                        })
                );
    };

    @Override
    public Mono<Void> delete(Long id) {
        return appointmentRepository.deleteById(id);
    }

    @Override
    public Flux<AppointmentDto> findAll() {
        return appointmentRepository.findAll().map(ele-> modelMapper.map(ele, AppointmentDto.class));
    }

    @Override
    public Mono<AppointmentDto> findById(Long id) {
        return appointmentRepository.findById(id).map(ele-> modelMapper.map(ele, AppointmentDto.class));
    }

    @Override
    public Flux<AppointmentDto> findByDoctorId(Long id) {
        return appointmentRepository.findByDoctorId(id).map(ele-> modelMapper.map(ele, AppointmentDto.class));
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
