package com.example.demo01.conf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
//@EnableWebSecurity
public class SecurityConfig{}
/*extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("---------------------------");
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
                log.info("UserDetails username :{}", username);
                return readerRepository.findById(username).get();
            }
        });
    }
}*/
