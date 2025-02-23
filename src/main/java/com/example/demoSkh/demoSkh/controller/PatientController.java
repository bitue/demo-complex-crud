package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.model.Patient;
import com.example.demoSkh.demoSkh.services.DoctorService;
import com.example.demoSkh.demoSkh.services.PatientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/patient")
public class PatientController {


    final PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;

    }

    @PostMapping
    public Mono<Patient> addPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient) ;
    }

    @GetMapping
    public Flux<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Mono<Patient> getPatientById(@PathVariable("id") long id) {
        return patientService.getPatient(id) ;
    }

    @PutMapping("/{id}")
    public Mono<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        return patientService.updatePatient(patient, id) ;
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePatient(@PathVariable("id") long id) {
        return patientService.deletePatient(id) ;
    }

}
