package project.project1.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.project1.menu.entity.Account;
import project.project1.menu.security.AccountDetails;
import project.project1.menu.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getByUsername(Integer.parseInt(username));
        if (account == null) {
            throw new UsernameNotFoundException("Khong tim thay user : " + username);
        }
        return new AccountDetails(account);
    }
}
