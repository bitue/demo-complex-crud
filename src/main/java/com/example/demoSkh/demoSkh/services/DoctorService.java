package com.example.demoSkh.demoSkh.services;
import com.example.demoSkh.demoSkh.model.Doctor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorService {
    public Mono<Doctor> save(Doctor doctor);
    public Flux<Doctor> findAll();
    public Mono<Doctor> findById(Long id);
    public Mono<Void> deleteById(Long id);
    public Mono<Doctor> update(Doctor doctor, Long id);


}
