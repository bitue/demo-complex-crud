package com.example.demoSkh.demoSkh.dto;


import com.example.demoSkh.demoSkh.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    @Column("doctor_id")
    private Long doctor_id;
    private String name;
    private String designation;
    private String specialization;
    private String address;


}
