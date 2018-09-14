package tdd.kata.one.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import tdd.kata.one.domain.Account;

@Service
public class MailerServiceImpl implements MailerService {

    private MailSender mailSender;

    public MailerServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendConfirmationEmail(Account account) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Hello " + account.getName());
        message.setText("This is the text");
        message.setTo(account.getEmail());
        mailSender.send(message);
    }
}
