package com.example.demoSkh.demoSkh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("Appointment")
public class Appointment {
    @Id
    @Column("appointment_Id")
    private Long appointmentId;
    @Column("patient_Id")
    private Long patientId;
    @Column("doctor_id")
    private Long doctorId;
    private String details;
}
