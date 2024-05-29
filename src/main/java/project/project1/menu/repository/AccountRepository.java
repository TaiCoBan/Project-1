package project.project1.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project1.menu.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getByUsername(int username);
    void deleteByUsername(int username);
}
