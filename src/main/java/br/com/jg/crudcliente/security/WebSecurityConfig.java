package br.com.jg.crudcliente.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //@TODO por enquanto acesso total as requisições, até que o controle de acesso valide registros do BD
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/email").permitAll()
                .antMatchers("/endereco").permitAll()
                .antMatchers("/logOperacoes").permitAll()
                .antMatchers("/perfil").permitAll()
                .antMatchers("/telefone").permitAll()
                .antMatchers("/tipoTelefone").permitAll()
                .antMatchers("/usuario").permitAll()
//                .antMatchers(HttpMethod.POST, "login").permitAll()
                .anyRequest().authenticated()
                .and()

                // filtra requisições de login
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)

                // filtra outras requisições para verificar a presença do JWT no header
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Cria uma conta default
        auth.inMemoryAuthentication()
                .withUser("administrador")
                .password("password")
                .roles("ADMIN");
    }
}
