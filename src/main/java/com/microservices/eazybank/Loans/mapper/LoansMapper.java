package com.microservices.eazybank.Loans.mapper;

import com.microservices.eazybank.Loans.dto.LoansDto;
import com.microservices.eazybank.Loans.entity.Loans;

public class LoansMapper {

    /**
     *  This method will convert loans to loansDto
     * @param loans
     * @param loansDto
     * @return LoansDto
     */
    public static LoansDto maptoLoansDto(Loans loans, LoansDto loansDto) {
        //setting up properties
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoanAmount(loans.getTotalLoanAmount());
        loansDto.setAmountLoanPaid(loans.getAmountLoanPaid());
        loansDto.setOutstandingLoanAmount(loans.getOutstandingLoanAmount());
        return loansDto;
    }

    /**
     *  This method will convert loansDto to loans
     * @param loansDto
     * @param loans
     * @return Loans
     */
    public static Loans maptoLoans(LoansDto loansDto, Loans loans) {
        //setting up properties
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoanAmount(loansDto.getTotalLoanAmount());
        loans.setAmountLoanPaid(loansDto.getAmountLoanPaid());
        loans.setOutstandingLoanAmount(loansDto.getOutstandingLoanAmount());
        return loans;
    }
}
