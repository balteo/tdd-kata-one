package tdd.kata.one.service;

import tdd.kata.one.domain.Account;

public interface MailerService {

    void sendConfirmationEmail(Account account);
}
