package com.playlist.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private JwtAtuthenticationEntryPoint unauthorizeHandler;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtFilter jwtAnthAutheticationFilter;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .csrf().disable()
        .cors().disable()
        .authorizeRequests()
        // Endpoints Públicos (No requieren autenticación)
        .antMatchers("/generate-token").permitAll()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers("/h2-console/**").permitAll()
        
        // Autorización Basada en Roles
        .antMatchers(HttpMethod.POST, "/lists/**/add-song").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.GET, "/lists/**").hasAnyRole("USER", "ADMIN") // Usuarios y Admins pueden ver listas
        .antMatchers(HttpMethod.POST, "/lists/**").hasRole("ADMIN") // Solo ADMIN puede crear listas
        .antMatchers(HttpMethod.DELETE, "/lists/**").hasRole("ADMIN") // Solo ADMIN puede borrar listas
        
        // Todo lo demás requiere autenticación
        .anyRequest().authenticated()
        
        .and()
        .headers().frameOptions().disable() // Permite H2 Console en navegador
        
        .and()
        .exceptionHandling().authenticationEntryPoint(unauthorizeHandler)
        
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Agregar el filtro JWT antes del filtro de autenticación de usuario y contraseña
		http.addFilterBefore(jwtAnthAutheticationFilter, UsernamePasswordAuthenticationFilter.class);
        
    }
    
    
}
