package com.example.demoSkh.demoSkh.services;


import com.example.demoSkh.demoSkh.model.Appointment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {
    public Mono<Appointment> save (Appointment appointment) ;
    public Mono<Appointment> update (Appointment appointment, Long id) ;
    public Mono<Void> delete (Long id) ;
    public Flux<Appointment> findAll () ;
    public Mono<Appointment> findById (Long id) ;
    public Flux<Appointment> findByDoctorId (Long id) ;

}
