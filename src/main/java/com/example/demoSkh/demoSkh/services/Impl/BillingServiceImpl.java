package com.example.demoSkh.demoSkh.services.Impl;

import com.example.demoSkh.demoSkh.model.Billing;
import com.example.demoSkh.demoSkh.repository.AppointmentRepository;
import com.example.demoSkh.demoSkh.repository.BillingRepository;
import com.example.demoSkh.demoSkh.services.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class BillingServiceImpl implements BillingService {

    private BillingRepository billingRepository;
    private AppointmentRepository appointmentRepository;

    @Override
    public Mono<Billing> save(Billing billing) {
        // check the appointId is valid or not then save it
        return checkAppointIdIsValid(billing.getAppointmentId()).then(billingRepository.save(billing));
    }

    @Override
    public Mono<Billing> findById(Long id) {
        return billingRepository.findById(id);
    }

    @Override
    public Flux<Billing> findAll() {
        return billingRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return billingRepository.deleteById(id);
    }

    @Override
    public Mono<Billing> update(Long id, Billing billing) {
       return  Mono.when(checkAppointIdIsValid(billing.getAppointmentId()))
                .then(billingRepository.findById(id))
                .switchIfEmpty(Mono.error(new RuntimeException("No Billing Id found "))).flatMap(ele -> {
                    ele.setBillAmount(billing.getBillAmount());
                    ele.setAppointmentId(billing.getAppointmentId());
                    ele.setBillAmount(billing.getBillAmount());
                    return billingRepository.save(ele);
                });
    }

    @Override
    public Mono<Billing> findByAppointmentId(Long appointmentId) {
        return billingRepository.findByAppointmentId(appointmentId);
    }

    private Mono<Void> checkAppointIdIsValid(Long appointmentId){
        if (appointmentId == null) {
            return Mono.error(new IllegalArgumentException("AppointmentId cannot be null"));
        }

        return appointmentRepository.findById(appointmentId)
                .switchIfEmpty(Mono.error(new RuntimeException("AppointmentId not found")))
                .then();
    }
}
