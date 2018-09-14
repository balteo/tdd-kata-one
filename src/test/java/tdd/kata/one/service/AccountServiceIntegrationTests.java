package tdd.kata.one.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tdd.kata.one.domain.Account;
import tdd.kata.one.repository.AccountRepository;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountServiceIntegrationTests {

    @Autowired
    AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void accountServiceIsInjected() {
    }

    @Test
    void passwordShouldHaveMinLength() {
        Account account = Account
                .builder()
                .name("Toto")
                .email("toto@example.com")
                .password("a")
                .build();

        assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> accountService.signUp(account));

        verify(accountRepository, never()).save(any(Account.class));
    }

}
