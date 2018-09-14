package tdd.kata.one.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class SignUpRouter {

    private SignUpHandler signUpHandler;

    public SignUpRouter(SignUpHandler signUpHandler) {
        this.signUpHandler = signUpHandler;
    }

    public RouterFunction<ServerResponse> routes() {
        return nest(path("/account"),
            route(POST("/signUp").and(accept(APPLICATION_JSON)), signUpHandler::signUp));
    }
}
