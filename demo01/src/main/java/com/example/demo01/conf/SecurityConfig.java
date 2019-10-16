package com.example.demo01.conf;

import com.example.demo01.dao.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//
                .antMatchers("/").access("hasRole('READER')")//要求登录具有 READER 角色
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")//设置登录表单路径
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {// 自定义  UserDetailsService
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return readerRepository.findById(username).get();
            }
        });
    }
}
