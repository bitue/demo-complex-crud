package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.model.Billing;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BillingRepository extends ReactiveCrudRepository<Billing, Long> {
    public Mono<Billing> findByAppointmentId(Long appointmentId);
}
