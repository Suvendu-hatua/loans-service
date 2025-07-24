package com.microservices.eazybank.Loans.mapper;

import com.microservices.eazybank.Loans.dto.LoansDto;
import com.microservices.eazybank.Loans.entity.Loans;

public class LoansMapper {
  private LoansMapper() {
  }

  /**
   * This method will convert loans to loansDto
   *
   * @param loans    loans info
   * @param loansDto loansDto
   * @return LoansDto
   */
  public static LoansDto maptoLoansDto(Loans loans, LoansDto loansDto) {
    //setting up properties
    loansDto.setLoanNumber(loans.getLoanNumber());
    loansDto.setLoanType(loans.getLoanType());
    loansDto.setMobileNumber(loans.getMobileNumber());
    loansDto.setTotalLoanAmount(loans.getTotalLoan());
    loansDto.setAmountLoanPaid(loans.getAmountPaid());
    loansDto.setOutstandingLoanAmount(loans.getOutstandingAmount());
    return loansDto;
  }

  /**
   * This method will convert loansDto to loans
   *
   * @param loansDto loansDto
   * @param loans    loans info
   * @return Loans
   */
  public static Loans maptoLoans(LoansDto loansDto, Loans loans) {
    //setting up properties
    loans.setLoanNumber(loansDto.getLoanNumber());
    loans.setLoanType(loansDto.getLoanType());
    loans.setMobileNumber(loansDto.getMobileNumber());
    loans.setTotalLoan(loansDto.getTotalLoanAmount());
    loans.setAmountPaid(loansDto.getAmountLoanPaid());
    loans.setOutstandingAmount(loansDto.getOutstandingLoanAmount());
    return loans;
  }
}
