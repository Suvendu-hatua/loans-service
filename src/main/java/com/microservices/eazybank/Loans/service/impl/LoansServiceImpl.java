package com.microservices.eazybank.Loans.service.impl;

import com.microservices.eazybank.Loans.constants.LoansConstants;
import com.microservices.eazybank.Loans.dto.LoansDto;
import com.microservices.eazybank.Loans.entity.Loans;
import com.microservices.eazybank.Loans.exceptionHandling.LoanAlreadyExistsException;
import com.microservices.eazybank.Loans.exceptionHandling.ResourceNotFoundException;
import com.microservices.eazybank.Loans.mapper.LoansMapper;
import com.microservices.eazybank.Loans.repository.LoansRepository;
import com.microservices.eazybank.Loans.service.LoansService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements LoansService {

    private LoansRepository loansRepository;

    @Autowired
    public LoansServiceImpl(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    /**
     * Method is for creating a new loan and saving it into DB
     * @param mobileNumber
     * @return boolean
     */
    @Override
    @Transactional
    public boolean createLoan(String mobileNumber) {
        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if(loans.isPresent()) {
            throw new LoanAlreadyExistsException("Loans already exists with the given mobile number "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
        return true;

    }

    /**
     * Method is to fetch Loan details from Banking MicroService.
     * @param mobileNumber
     * @return LoansDto
     */
    @Override
    public LoansDto fetchLoansDetails(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", mobileNumber));

        //converting loans to loansDto
        LoansDto loansDto = LoansMapper.maptoLoansDto(loans, new LoansDto());
        return loansDto;
    }

    /**
     * Method is to update Loan Details in Banking MicroServices.
     * @param loansDto
     * @return boolean
     */
    @Override
    @Transactional
    public boolean updateLoanDetails(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoansMapper.maptoLoans(loansDto, loans);
        loansRepository.save(loans);
        return  true;
    }

    /**
     * This method is to delete loan details by mobile Number
     * @param mobileNumber
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteLoanDetails(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", mobileNumber));
        loansRepository.deleteById(loans.getLoadId());
        return  true;
    }

    /**
     *  It's  a private method, used for creating a new loan.
     * @param mobileNumber
     * @return Loans
     */
    private Loans createNewLoan(String mobileNumber) {
        //creating an instance of Loan
        Loans loans = new Loans();
        //Setting up properties
        loans.setMobileNumber(mobileNumber);
        loans.setLoanType(LoansConstants.HOME_LOAN);
        loans.setTotalLoanAmount(LoansConstants.NEW_LOAN_LIMIT);
        loans.setAmountLoanPaid(0);
        loans.setOutstandingLoanAmount(LoansConstants.NEW_LOAN_LIMIT);
        //Generating Loans Number
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loans.setLoanNumber(Long.toString(randomLoanNumber));
        return loans;
    }
}
