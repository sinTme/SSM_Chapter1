package com.powek.service;

import com.powek.dao.domain.Account;

public interface AccountService {
    /**
     * 用户登录
     * @param accountName
     * @param password
     */
    Account login(String accountName, String password);

    /**
     * 根据条件查找
     * @param account
     * @return
     */
    Account getAccountByConditions(Account account);

    /**
     * 新增用户
     * @param account
     */
    void addAccount(Account account);

    /**
     * 更新用户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(Long id);
}
