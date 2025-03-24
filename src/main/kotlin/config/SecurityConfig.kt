package com.example.creditSimulator.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth -> auth.anyRequest().permitAll() } // Permite todas as requisições sem autenticação
            .csrf { it.disable() } // Desabilita CSRF (apenas para testes)

        return http.build()
    }
}
