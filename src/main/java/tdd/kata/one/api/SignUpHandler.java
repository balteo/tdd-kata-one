package tdd.kata.one.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tdd.kata.one.domain.Account;
import tdd.kata.one.service.ReactiveAccountService;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class SignUpHandler {

    private ReactiveAccountService reactiveAccountService;

    public SignUpHandler(ReactiveAccountService reactiveAccountService) {
        this.reactiveAccountService = reactiveAccountService;
    }

    public Mono<ServerResponse> signUp(ServerRequest request) {
        Mono<Account> account = request.bodyToMono(Account.class);
        return ok().build(reactiveAccountService.signUp(account));
    }
}
