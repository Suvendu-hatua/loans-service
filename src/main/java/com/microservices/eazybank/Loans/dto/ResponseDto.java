package com.microservices.eazybank.Loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ResponseDto {
    @Schema(
            description = "Http status of the response",example = "200"
    )
    private String status;

    @Schema(
            description = "message of response",example = "Success Message"
    )
    private String message;
}
