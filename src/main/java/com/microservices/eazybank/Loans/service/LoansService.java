package com.microservices.eazybank.Loans.service;


import com.microservices.eazybank.Loans.dto.LoansDto;

public interface LoansService {
    boolean createLoan(String mobileNumber);

    LoansDto fetchLoansDetails(String mobileNumber);

    boolean updateLoanDetails(LoansDto loansDto);

    boolean deleteLoanDetails(String mobileNumber);
}
