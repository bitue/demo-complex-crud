package com.example.demoSkh.demoSkh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    @Id
    @Column("id")
    private Long id ;
    @Column("appointment_id")
    private Long appointmentId;
    @Column("patient_name")
    private String patientName;
    @Column("patient_phone")
    private String patientPhone;
    @Column("doctor_name")
    private String doctorName;
    @Column("doctor_speciality")
    private String doctorSpecialty;
    private String details;
}
