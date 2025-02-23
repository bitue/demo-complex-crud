package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.dto.PatientDto;
import com.example.demoSkh.demoSkh.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    final PatientService patientService;

    @PostMapping
    public Mono<PatientDto> addPatient(@RequestBody PatientDto patientDto) {
        return patientService.savePatient(patientDto) ;
    }

    @GetMapping
    public Flux<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Mono<PatientDto> getPatientById(@PathVariable("id") long id) {
        return patientService.getPatient(id) ;
    }

    @PutMapping("/{id}")
    public Mono<PatientDto> updatePatient(@PathVariable("id") long id, @RequestBody PatientDto patientDto) {
        return patientService.updatePatient(patientDto, id) ;
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePatient(@PathVariable("id") long id) {
        return patientService.deletePatient(id) ;
    }

}
