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
@Table("patient")
public class Patient {

    @Id
    @Column("patient_id")
    private Long patientId;
    private String name;
    private String address;
    private String phone;

}
