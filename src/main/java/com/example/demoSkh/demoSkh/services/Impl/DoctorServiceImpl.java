package com.example.demoSkh.demoSkh.services.Impl;

import com.example.demoSkh.demoSkh.model.Doctor;
import com.example.demoSkh.demoSkh.repository.DoctorRepository;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.DoctorService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;

    DoctorServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Mono<Doctor> save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Flux<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Mono<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return doctorRepository.deleteById(id);
    }

    @Override
    public Mono<Doctor> update(Doctor doctor, Long id) {
        return doctorRepository.findById(id)
                .flatMap(existingDoctor -> {
                    existingDoctor.setName(doctor.getName());
                    existingDoctor.setAddress(doctor.getAddress());
                    existingDoctor.setDesignation(doctor.getDesignation());
                    existingDoctor.setSpecialization(doctor.getSpecialization());
                    return doctorRepository.save(existingDoctor);
                });
    }

}
