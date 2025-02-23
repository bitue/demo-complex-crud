package com.example.demoSkh.demoSkh.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PatientDto {
    @Column("patient_id")
    private Long patient_id;
    private String name;
    private String address;
    private String phone;
    @Column("doctor_id")
    private Long doctor_id;
}
