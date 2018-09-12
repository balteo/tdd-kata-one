package tdd.kata.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdd.kata.one.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
