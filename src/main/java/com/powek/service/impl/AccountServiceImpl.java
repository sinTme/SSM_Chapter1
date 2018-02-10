package com.powek.service.impl;

import com.powek.common.utils.DecodeUtil;
import com.powek.dao.domain.Account;
import com.powek.dao.mapper.AccountMapper;
import com.powek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account login(String accountName, String password) {
        Account query = new Account();
        query.setAccountName(accountName);
        Account account = accountMapper.queryAccount(query);
        if (account != null && DecodeUtil.verifyPwd(password, account.getPassword()))
        {
            return account;
        }
        return null;
    }

    public Account getAccountByConditions(Account account) {
        return null;
    }

    public void addAccount(Account account) {
        account.setPassword(DecodeUtil.decodePwd(account.getPassword()));
        accountMapper.addAccount(account);
    }

    public void updateAccount(Account account) {

    }

    public void deleteById(Long id) {

    }
}
