package com.powek.controller.account;

import com.powek.common.anotation.authen;
import com.powek.common.utils.JwtUtil;
import com.powek.common.utils.Response;
import com.powek.dao.domain.Account;
import com.powek.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户登录",httpMethod = "GET",response = Account.class)
    public Response<Account> login(HttpServletResponse httpResponse , @ApiParam(value = "账号") @RequestParam String accountName, @ApiParam(value = "密码") @RequestParam String password)
    {
        Response<Account> response = new Response<Account>(0,"success");
        Account account = accountService.login(accountName,password);
        response.setResult(account);
        String token = JwtUtil.createToken(account.getId() + "", account.getAccountName());
        httpResponse.addHeader("Authorization",token);
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增用户")
    @authen
    public void addAccount(@RequestBody Account account)
    {
        try {
            accountService.addAccount(account);
            System.out.println(account.getId());
        }
        catch (Exception e)
        {
            System.out.println("error:" + e.getMessage());
        }
    }
}
