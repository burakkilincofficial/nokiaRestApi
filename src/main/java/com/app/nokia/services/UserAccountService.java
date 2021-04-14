package com.app.nokia.services;

import com.app.nokia.common.exceptions.UserAccountNotFoundException;
import com.app.nokia.entity.UserAccount;
import com.app.nokia.model.dto.CreateUserAccountDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserAccountService {
    Page<UserAccount> getAll(Integer pageNo, Integer pageSize);

    List<UserAccount> getAll();

    UserAccount findById(Long id);

    void saveOrUpdate(UserAccount bankAccount);

    void deleteById(Long id);

    UserAccount createUserAccount(CreateUserAccountDto createUserAccountDto);

    UserAccount updateUserAccount(CreateUserAccountDto createUserAccountDto) throws UserAccountNotFoundException;

    void deleteUserAccountById(Long id) throws UserAccountNotFoundException;
}
