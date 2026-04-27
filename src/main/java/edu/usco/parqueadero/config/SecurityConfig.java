package edu.usco.parqueadero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Configuración de los 3 usuarios requeridos
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMINISTRADOR")
                .build();

        UserDetails aco = User.withDefaultPasswordEncoder()
                .username("aco")
                .password("123")
                .roles("ACOMODADOR")
                .build();

        UserDetails cli = User.withDefaultPasswordEncoder()
                .username("cli")
                .password("123")
                .roles("CLIENTE")
                .build();
        
        return new InMemoryUserDetailsManager(admin, aco, cli);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Permitir acceso a login y consola de base de datos
                .requestMatchers("/login", "/h2-console/**").permitAll()
                // El Administrador es el único que registra (POST /admin/**)
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                // Acomodador y Admin pueden actualizar ubicaciones
                .requestMatchers("/acomodador/**").hasAnyRole("ADMINISTRADOR", "ACOMODADOR")
                // Cualquier otra ruta requiere estar autenticado
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            .logout(logout -> logout.permitAll())
            // Página personalizada para cuando un usuario no tiene permiso (ej. Cliente intentando registrar)
            .exceptionHandling(ex -> ex.accessDeniedPage("/403"))
            // Deshabilitar CSRF y FrameOptions para que funcione la consola H2 y los formularios simples
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));
            
        return http.build();
    }
}