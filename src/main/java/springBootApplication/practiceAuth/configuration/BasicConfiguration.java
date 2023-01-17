package springBootApplication.practiceAuth.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicConfiguration  {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(HttpMethod.GET,"/students/**,/student/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST,"/students").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/students/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();




        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;

    }
}