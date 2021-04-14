package com.app.nokia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmountDto {
    @NotNull
    private Double amount;
}
