//package com.ntt.configserver;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
///**
// *
// * @author : nguyentthai96 - nguyentthai96@gmail.com
// * @version :
// * @since :  11/12/2024, Wednesday
// **/
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http
//                .authorizeRequests()
//                .antMatchers("/actuator/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//        ;
//    }
//}
