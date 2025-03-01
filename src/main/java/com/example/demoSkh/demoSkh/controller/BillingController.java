package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.dto.BillingDto;
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
    public Mono<BillingDto> getBill(@PathVariable  Long id) {
        return billingService.findById(id);
    }

    @GetMapping
    public Flux<BillingDto> getAllBills() {
        return billingService.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBill(@PathVariable Long id) {
        return billingService.deleteById(id);
    }

    @PostMapping
    public Mono<BillingDto> createBill(@RequestBody BillingDto billingDto) {
        return billingService.save(billingDto);
    }

    @PutMapping("/{id}")
    public Mono<BillingDto> updateBill(@PathVariable Long id, @RequestBody BillingDto billingDto) {
        return billingService.update(id,billingDto);
    }

    @GetMapping("/appointment/{appointmentId}")
    public Flux<BillingDto> getBillByAppointmentId(@PathVariable Long appointmentId) {
        return billingService.findByAppointmentId(appointmentId);
    }

}
