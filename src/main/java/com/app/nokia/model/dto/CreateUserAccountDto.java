package com.app.nokia.model.dto;

import com.app.nokia.validation.PhoneLengthConstraint;
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
public class CreateUserAccountDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @PhoneLengthConstraint
    @NotNull
    private String phone;
    @NotNull
    private String email;
    private String address;
    @NotNull
    private String country;
    @NotNull
    private String department;

}
