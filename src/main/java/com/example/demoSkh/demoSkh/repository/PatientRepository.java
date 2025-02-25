package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.model.Patient;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;


@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
    // query to fetch data by multiple or single criteria
    @Query("SELECT *\n"
            + "FROM patient\n"
            + "WHERE \n"
            + "    (:city IS NULL OR city = :city)\n"
            + "    AND (:state IS NULL OR state = :state)\n"
            + "    AND (:city IS NULL OR state = :city)\n"
            + "    AND (\n"
            + "         (:startDate IS NULL OR STR_TO_DATE(date_of_registration, '%d-%m-%Y') >= STR_TO_DATE(:startDate, '%d-%m-%Y'))\n"
            + "         AND (:endDate IS NULL OR STR_TO_DATE(date_of_registration, '%d-%m-%Y') <= STR_TO_DATE(:endDate, '%d-%m-%Y'))\n"
            + "    )\n")
    public Flux<Patient>patientSearchByMultipleField (String startDate , String endDate , String state, String city);


    // get patient list start date and end date interval of date of registration
    @Query("SELECT * " +
            "FROM patient " +
            "WHERE STR_TO_DATE(date_of_registration, '%d-%m-%Y') > STR_TO_DATE(:startDate, '%d-%m-%Y') " +
            "AND STR_TO_DATE(date_of_registration, '%d-%m-%Y') < STR_TO_DATE(:endDate, '%d-%m-%Y')")
    Flux<Patient> getPatientByStartDateAndEndDate(String startDate, String endDate);

}
