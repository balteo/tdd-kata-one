package tdd.kata.one.service;

import org.springframework.stereotype.Service;
import tdd.kata.one.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
