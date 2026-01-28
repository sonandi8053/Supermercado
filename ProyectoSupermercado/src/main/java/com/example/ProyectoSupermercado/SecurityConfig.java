package com.example.ProyectoSupermercado;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // habilita @PreAuthorize
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // API REST → no usamos CSRF
                .csrf(csrf -> csrf.disable())

                // Stateless (clave si después usás JWT)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Autorización por endpoints
                .authorizeHttpRequests(auth -> auth
                        // públicos
                        .requestMatchers(
                                "/auth/**",
                                "/h2-console/**"
                        ).permitAll()

                        // clientes
                        .requestMatchers("/pedidos/**").hasRole("CLIENTE")

                        // depósito / stock
                        .requestMatchers("/reposiciones/**").hasAnyRole(
                                "REPONEDOR",
                                "ENCARGADO_DEPOSITO",
                                "GERENTE",
                                "ADMIN"
                        )

                        // administración
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // cualquier otra request
                        .anyRequest().authenticated()
                )

                // desactivamos form login
                .formLogin(form -> form.disable())
                .httpBasic(Customizer.withDefaults());

        // para H2 Console
        http.headers(headers ->
                headers.frameOptions(frame -> frame.disable())
        );

        return http.build();
    }

    // 🔑 BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


