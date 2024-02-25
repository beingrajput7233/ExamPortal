package com.exam.examserver.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder()
//                .username("john").password(passwordEncoder().encode("123"))
//                .roles("Admin").build();
//        // noop signifies no operation like encryption etc. applied on password
//        UserDetails mary= User.builder()
//                .username("mary").password(passwordEncoder().encode("123"))
//                .roles("Admin" ).build();
//
//
//
//        return new InMemoryUserDetailsManager(john,mary);
//
//        // now spring-boot will not use the user/passwd from app.properties
//    }
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    jdbcUserDetailsManager.setUsersByUsernameQuery(
            "SELECT username, password, enabled FROM users WHERE username=?"
    );

    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT users.username, roles.role_name " +
                    "FROM users " +
                    "JOIN user_role ON users.id = user_role.user_id " +
                    "JOIN roles ON user_role.role_role_id = roles.role_id " +
                    "WHERE users.username = ?"
    );

    return jdbcUserDetailsManager;
}


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


}
