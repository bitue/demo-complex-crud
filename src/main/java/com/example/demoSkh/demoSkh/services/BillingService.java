package com.example.demoSkh.demoSkh.services;
import com.example.demoSkh.demoSkh.dto.BillingDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillingService {
    public Mono<BillingDto> save(BillingDto billingDto);
    public Mono<BillingDto> findById(Long id);
    public Flux<BillingDto> findAll();
    public Mono<Void> deleteById(Long id);
    public Mono<BillingDto> update(Long id, BillingDto billing);
    // extra method
    public Flux<BillingDto> findByAppointmentId(Long appointmentId);
}
