package com.app.nokia.services.impl;

import com.app.nokia.common.exceptions.UserAccountNotFoundException;
import com.app.nokia.entity.UserAccount;
import com.app.nokia.model.dto.CreateUserAccountDto;
import com.app.nokia.repository.UserAccountRepository;
import com.app.nokia.services.UserAccountService;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public static String generateHashed() {
        AtomicReference<String> uniques = new AtomicReference<>("");
        return Hashing.sha256().hashString(uniques.toString(), StandardCharsets.UTF_8).toString();
    }

    @Override
    public Page<UserAccount> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return userAccountRepository.findAll(pageable);
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount findById(Long id) {
        Optional<UserAccount> bankAccount = userAccountRepository.findById(id);
        return bankAccount.orElse(null);
    }

    @Override
    public void saveOrUpdate(UserAccount bankAccount) {
        userAccountRepository.save(bankAccount);
    }

    @Override
    public void deleteById(Long id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    public UserAccount createUserAccount(CreateUserAccountDto createUserAccountDto) {
        UserAccount bankAccount = UserAccount.builder()
                .id(createUserAccountDto.getId())
                .address(createUserAccountDto.getAddress())
                .country(createUserAccountDto.getCountry())
                .department(createUserAccountDto.getDepartment())
                .phone(createUserAccountDto.getPhone())
                .name(createUserAccountDto.getName())
                .email(createUserAccountDto.getEmail())
                .build();

        saveOrUpdate(bankAccount);

        return bankAccount;

    }

    private void checkIdIsExist(CreateUserAccountDto createUserAccountDto) throws UserAccountNotFoundException {
        UserAccount userAccount = findById(createUserAccountDto.getId());
        if (userAccount == null) {
            throw new UserAccountNotFoundException(createUserAccountDto.getId());
        }
    }

    @Override
    public UserAccount updateUserAccount(CreateUserAccountDto createUserAccountDto) throws UserAccountNotFoundException {
        UserAccount userAccount = findById(createUserAccountDto.getId());
        if (userAccount == null) {
            throw new UserAccountNotFoundException(createUserAccountDto.getId());
        }
        return userAccount;
    }

    @Override
    public void deleteUserAccountById(Long id) throws UserAccountNotFoundException {
        if (findById(id) == null) {
            throw new UserAccountNotFoundException(id);
        }
        deleteById(id);
    }

}
