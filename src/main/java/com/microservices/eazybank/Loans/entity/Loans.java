package com.microservices.eazybank.Loans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "loans")
@NoArgsConstructor
@AllArgsConstructor
public class Loans extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadId;

    @Column(unique = true, nullable = false)
    private String mobileNumber;

    @Column(unique = true, nullable = false)
    private String loanNumber;
    private String loanType;
    private int totalLoanAmount;
    private int amountLoanPaid;
    private int outstandingLoanAmount;
}
