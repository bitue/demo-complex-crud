package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.model.Doctor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends ReactiveCrudRepository<Doctor, Long> {
}
