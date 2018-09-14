package tdd.kata.one.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
@Entity
public class Account {

    @Id
    private Long id;
    private String name;
    private String email;

    @Min(6)
    private String password;
}
