package tdd.kata.one.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tdd.kata.one.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
class ServiceTests {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;


    @Test
    void accountServiceIsInstantiated() {
    }

}
