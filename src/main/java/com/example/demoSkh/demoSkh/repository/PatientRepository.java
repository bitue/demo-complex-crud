package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.model.Patient;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
}
