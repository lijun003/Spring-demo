package com.example.demo1.service;

import com.example.demo1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by daz on 29/06/2017.
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {

    private AccountRepository accountRepository;
    @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository
                .findByUsername(username)
                .map(account -> new User(account.getUsername(), bCryptPasswordEncoder.encode(account.getPassword()), AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN")))
                .orElseThrow(() -> new UsernameNotFoundException("Could not find " + username));
    }
}
