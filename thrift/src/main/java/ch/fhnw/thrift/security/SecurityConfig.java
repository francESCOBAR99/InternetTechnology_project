package ch.fhnw.thrift.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import ch.fhnw.thrift.data.repository.UserRepository;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            ch.fhnw.thrift.data.domain.User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
            );
        };
    }
        //Create two users with different roles and add them to the in-memory user store

      //  return new InMemoryUserDetailsManager(
       //     User.withUsername("myuser")
                //.password("{noop}password") //create user with an encrypted password instead of the plain text password
         //       .password("{bcrypt}$2a$10$9fxQtdWuRaYn5UchAm5iAexbPi7tmRadnDogJwXPR9fVDJyt9g/su")
         //       .authorities("READ","ROLE_USER")
         //       .build(), 
         //   User.withUsername("myadmin")
                //.password("{noop}password") //create user with an encrypted password instead of the plain text password
          //      .password("{bcrypt}$2a$10$9fxQtdWuRaYn5UchAm5iAexbPi7tmRadnDogJwXPR9fVDJyt9g/su")
          //      .authorities("READ","ROLE_ADMIN")
          //      .build());

    //}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/offer").hasRole("USER") //note that the role need not be prefixed with "ROLE_"
                        .requestMatchers("/offer/item/**").hasRole("ADMIN") //note that the role need not be prefixed with "ROLE_"
                        .requestMatchers("/offer/**",
                                                    "/**", //allow access to the home page
                                                    "/swagger-ui.html", //allow access to the swagger UI
                                                    "/v3/api-docs/**",  //allow access to the swagger API documentation
                                                    "/swagger-ui/**",   //allow access to the swagger UI
                                                    "/h2-console/**")   //allow access to the h2-console
                                                    .permitAll() 
                        .anyRequest().hasAuthority("SCOPE_READ")           
                )       
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) //needed to allow access to the h2-console
                .formLogin(withDefaults()) //need to include a static import for withDefaults, see the imports at the top of the file
                .httpBasic(withDefaults())
                .build(); 
    } 



        
}
