package com.microservices.eazybank.Loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(
        name = "Loans",
        description = "Schema to hold Loans information"
)
@Setter
@Getter
@ToString
@AllArgsConstructor
public class LoansDto {
    @Schema(
            description = "Loan Number of the Customer",example = "345612456789"
    )
    @NotEmpty(message = "Loan Number can not be null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "Loan Number must be 12 digits")
    private String loanNumber;

    @Schema(
            description = "Loan Type of the Customer", example = "Home Loan"
    )
    @NotEmpty(message = "Loan Type can not be null or empty")
    private String loanType;

    @Schema(
            description = "Mobile Number of the Customer",example = "9876549872"
    )
    @NotEmpty(message = "Mobile Number can not be null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Total loan amount",example = "1000000"
    )
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoanAmount;

    @Schema(
            description = "Total loan amount paid by the Customer",example = "50000"
    )
    @PositiveOrZero(message = "Loan paid amount should be positive or zero")
    private  int amountLoanPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingLoanAmount;
}
