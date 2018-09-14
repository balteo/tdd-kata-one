package tdd.kata.one.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tdd.kata.one.domain.Account;

@Service
public class ReactiveAccountService {

    private AccountService accountService;

    public ReactiveAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Mono<Void> signUp(Mono<Account> accountMono) {
        return accountMono.flatMap(account -> {
            accountService.signUp(account);
            return Mono.empty();
        });
    }

}
