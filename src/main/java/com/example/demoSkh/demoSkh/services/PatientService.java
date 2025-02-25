package com.example.demoSkh.demoSkh.services;

import com.example.demoSkh.demoSkh.dto.PatientDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {
    public Mono<PatientDto> savePatient(PatientDto patientDto);
    public Mono<PatientDto> updatePatient(PatientDto patientDto, Long id);
    public Mono<PatientDto> getPatient(Long id);
    public Flux<PatientDto> getAllPatients();
    public Mono<Void> deletePatient(Long id);
    public Flux<PatientDto> patientSearchByMultipleField(String startDate, String endDate, String city , String state);
    public Flux<PatientDto> getPatientByStartDateAndEndDate(String startDate, String endDate);
}
