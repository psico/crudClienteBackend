package br.com.jg.crudcliente.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return new User("admin", "$2a$10$7gCP0nEjr7dvsXgZjxOtJ.UCzslrBgh2ZfeJLqQIJScZ6jxemV3bS", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Nome de usuario não encontrado: " + username);
        }
    }
}
