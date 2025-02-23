package com.example.demoSkh.demoSkh.services;
import com.example.demoSkh.demoSkh.model.Billing;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillingService {
    public Mono<Billing> save(Billing billing);
    public Mono<Billing> findById(Long id);
    public Flux<Billing> findAll();
    public Mono<Void> deleteById(Long id);
    public Mono<Billing> update(Long id, Billing billing);
    // extra method
    public Mono<Billing> findByAppointmentId(Long appointmentId);
}
