package tdd.kata.one.service;

import org.springframework.validation.annotation.Validated;
import tdd.kata.one.domain.Account;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface AccountService {

    void signUp(@Valid @NotNull Account account);
}
