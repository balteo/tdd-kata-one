package tdd.kata.one.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Account {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
