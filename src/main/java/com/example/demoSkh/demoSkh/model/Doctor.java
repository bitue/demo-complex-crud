package com.example.demoSkh.demoSkh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("doctor")
public class Doctor {
    @Id
    @Column("doctor_Id")
    private Long doctorId;
    private String name;
    private String designation;
    private String specialization;
    private String address;



}
