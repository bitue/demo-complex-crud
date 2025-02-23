package com.example.demoSkh.demoSkh.services.Impl;
import com.example.demoSkh.demoSkh.model.Patient;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.PatientService;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;



    PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    @Override
    public Mono<Patient> savePatient(Patient patient) {

        return patientRepository.save(patient);
    }

    @Override
    public Mono<Patient> updatePatient(Patient patient, Long id) {
       return patientRepository.findById(id)
               .flatMap(ele -> {
                     ele.setName(patient.getName());
                     ele.setAddress(patient.getAddress());
                     ele.setPhone(patient.getPhone());
                     return patientRepository.save(ele);
       });

    }

    @Override
    public Mono<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Flux<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Mono<Void> deletePatient(Long id) {
        return patientRepository.deleteById(id);
    }
}
