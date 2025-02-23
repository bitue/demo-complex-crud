package com.example.demoSkh.demoSkh.controller;


import com.example.demoSkh.demoSkh.model.Appointment;
import com.example.demoSkh.demoSkh.model.Billing;
import com.example.demoSkh.demoSkh.services.AppointmentService;
import com.example.demoSkh.demoSkh.services.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/billing")
@AllArgsConstructor
public class BillingController {

    private final BillingService billingService;
    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public Mono<Billing> getBill(Long id) {
        return billingService.findById(id);
    }

    @GetMapping
    public Flux<Billing> getAllBills() {
        return billingService.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBill(@PathVariable Long id) {
        return billingService.deleteById(id);
    }

    @PostMapping
    public Mono<Billing> createBill(@RequestBody Billing billing) {
        return billingService.save(billing);
    }

    @PutMapping("/{id}")
    public Mono<Billing> updateBill(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.update(id,billing);
    }

    @GetMapping("/appointment/{appointmentId}")
    public Mono<Billing> getBillByAppointmentId(@PathVariable Long appointmentId) {
        return billingService.findByAppointmentId(appointmentId);
    }


}
