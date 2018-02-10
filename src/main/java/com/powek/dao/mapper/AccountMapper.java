package com.powek.dao.mapper;

import com.powek.dao.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    Account queryAccount(Account account);

    void addAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Long id);
}
