package com.example.demoSkh.demoSkh.services;

import com.example.demoSkh.demoSkh.model.Patient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {

    public Mono<Patient> savePatient(Patient patient);
    public Mono<Patient> updatePatient(Patient patient, Long id);
    public Mono<Patient> getPatient(Long id);
    public Flux<Patient> getAllPatients();
    public Mono<Void> deletePatient(Long id);
}
