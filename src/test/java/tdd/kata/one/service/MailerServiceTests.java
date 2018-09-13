package tdd.kata.one.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import tdd.kata.one.domain.Account;

import java.util.Arrays;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MailerServiceTests {

    @InjectMocks
    private MailerServiceImpl mailerService;

    @Mock
    private MailSender mailSender;

    @Test
    void emailIsSent() {
        Account account = Account
                .builder()
                .name("Toto")
                .email("toto@example.com")
                .password("secret")
                .build();

        mailerService.sendConfirmationEmail(account);

        verify(mailSender).send(argThat((SimpleMailMessage message) -> Arrays.asList(Objects.requireNonNull(message.getTo())).contains("toto@example.com")));
    }
}
