package com.example.demoSkh.demoSkh.services;
import com.example.demoSkh.demoSkh.dto.DoctorDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorService {
    public Mono<DoctorDto> save(DoctorDto doctorDto);
    public Flux<DoctorDto> findAll();
    public Mono<DoctorDto> findById(Long id);
    public Mono<Void> deleteById(Long id);
    public Mono<DoctorDto> update(DoctorDto doctorDto, Long id);


}
