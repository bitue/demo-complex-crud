package com.example.demoSkh.demoSkh.services;
import com.example.demoSkh.demoSkh.dto.AppointmentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {
    public Mono<AppointmentDto> save (AppointmentDto appointmentDto) ;
    public Mono<AppointmentDto> update (AppointmentDto appointmentDto, Long id) ;
    public Mono<Void> delete (Long id) ;
    public Flux<AppointmentDto> findAll () ;
    public Mono<AppointmentDto> findById (Long id) ;
    public Flux<AppointmentDto> findByDoctorId (Long id) ;

}
