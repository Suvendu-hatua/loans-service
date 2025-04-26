package com.microservices.eazybank.Loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold Error response Information"
)
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(
            description = "Api path of the error response",example = "/api/v1/loans/path"
    )
    private String apiPath;

    @Schema(
            description = "Http status of the error response",example = "500"
    )
    private HttpStatus status;

    @Schema(
            description = "Description of the error response",example = "Error Message"
    )
    private String message;

    @Schema(
            description = "Current DateTime of the error response"
    )
    private LocalDateTime timestamp;
}
