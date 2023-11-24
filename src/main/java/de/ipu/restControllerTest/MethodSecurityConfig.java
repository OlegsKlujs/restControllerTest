package de.ipu.restControllerTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig  {

    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
        UserDetails user = User.builder()
                .username("Masha")
                .password(passwordEncoder().encode("Masha"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("password"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // enable in memory based authentication with a user named "user" and "admin"
//        System.out.println("Loading users");
//        auth.inMemoryAuthentication()
//                .withUser("Masha")
//                .password("")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER", "ADMIN");
//    }
}
