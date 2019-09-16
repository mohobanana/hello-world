package com.test.service.impl;

import com.test.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.AppConfigurationEntry;

public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

    }
}
