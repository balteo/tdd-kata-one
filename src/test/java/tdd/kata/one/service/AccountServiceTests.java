package tdd.kata.one.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tdd.kata.one.domain.Account;
import tdd.kata.one.repository.AccountRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTests {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private MailerServiceImpl mailerService;

    @Test
    void accountIsSaved() {
        Account account = Account
                .builder()
                .name("Toto")
                .email("toto@example.com")
                .password("secret")
                .build();

        accountService.signUp(account);

        verify(accountRepository).save(any(Account.class));
    }

    @Test
    void emailIsSentUponSignUp() {
        Account account = Account
                .builder()
                .name("Toto")
                .email("toto@example.com")
                .password("secret")
                .build();

        accountService.signUp(account);

        verify(mailerService).sendConfirmationEmail(any(Account.class));
    }
}
