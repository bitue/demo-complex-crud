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
@Table("billing")
public class Billing {
    @Id
    @Column("billing_id")
    private Long billingId;
    @Column("appointment_id")
    private Long appointmentId;
    @Column("bill_amount")
    private Long billAmount;

}
