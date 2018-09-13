package tdd.kata.one.service;

import org.springframework.stereotype.Service;
import tdd.kata.one.domain.Account;
import tdd.kata.one.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private MailerService mailerService;

    public AccountServiceImpl(AccountRepository accountRepository, MailerService mailerService) {
        this.accountRepository = accountRepository;
        this.mailerService = mailerService;
    }

    public void signUp(Account account) {
        mailerService.sendConfirmationEmail(account);
        accountRepository.save(account);
    }
}
