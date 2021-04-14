package com.app.nokia.repository;

import com.app.nokia.entity.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    Page<UserAccount> findAll(Pageable pageable);

    List<UserAccount> findAll();

}
