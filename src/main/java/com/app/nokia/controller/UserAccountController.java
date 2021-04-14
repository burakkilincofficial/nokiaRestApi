package com.app.nokia.controller;


import com.app.nokia.common.exceptions.BaseException;
import com.app.nokia.common.exceptions.UserAccountNotFoundException;
import com.app.nokia.entity.UserAccount;
import com.app.nokia.model.dto.CreateUserAccountDto;
import com.app.nokia.response.ApiResponse;
import com.app.nokia.response.ValidationErrorResponse;
import com.app.nokia.services.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserAccountController {
    private final UserAccountService userAccountService;


    @PostMapping("/user-account")
    public ApiResponse createUserAccount(@Valid @RequestBody CreateUserAccountDto createUserAccountDto) {

        UserAccount userAccount = userAccountService.createUserAccount(createUserAccountDto);

        return new ApiResponse("OK", userAccount.getId().toString());
    }

    @PutMapping("/user-account")
    public ApiResponse updateUserAccount(@Valid @RequestBody CreateUserAccountDto createUserAccountDto) throws UserAccountNotFoundException {

        UserAccount userAccount = userAccountService.updateUserAccount(createUserAccountDto);

        return new ApiResponse("OK", userAccount.getId().toString());
    }

    @GetMapping("/user-account/{id}")
    public UserAccount getUserAccount(@PathVariable("id") Long id) {

        return userAccountService.findById(id);
    }

    @GetMapping("/user-account")
    public List<UserAccount> getAllUserAccount() {

        return userAccountService.getAll();
    }

    @DeleteMapping(path = "/user-account/{id}")
    public ApiResponse deleteUserAccount(@PathVariable("id") Long id) throws UserAccountNotFoundException {
        userAccountService.deleteUserAccountById(id);
        return new ApiResponse("OK", id.toString());
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationErrorResponse> handleValidationError(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ValidationErrorResponse(e.getBindingResult().getFieldErrors()),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({UserAccountNotFoundException.class})
    public ResponseEntity<ApiResponse> handleBankAccountNotFoundException(UserAccountNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getStatus().value(), e.getMessage()),
                e.getStatus());

    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse> handleBaseException(BaseException e) {
        return new ResponseEntity<>(new ApiResponse(e.getStatus().value(), e.getMessage()), e.getStatus());
    }
}
