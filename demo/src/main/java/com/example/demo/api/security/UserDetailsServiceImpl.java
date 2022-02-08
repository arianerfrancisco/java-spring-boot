package com.example.demo.api.security;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service(value="userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override // cria-se todos os usuários necessários
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User user = userRep.findByLogin(username); // especificar o package, já que
        // já tem o import import com.example.demo.domain.UserRepository;
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        // return User.withUsername(username).password(encoder.encode("admin")).roles("USER", "ADMIN").build(); não precisa mais do encoder, pois já está salvo neste formato no BD
     //   return User.withUsername(username).password(user.getSenha()).roles("USER").build();
        // retornar dinamicamente usuario no BD
        return
    }
}
