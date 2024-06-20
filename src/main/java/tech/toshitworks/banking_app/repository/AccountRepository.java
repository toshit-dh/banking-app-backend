package tech.toshitworks.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
