package com.playlist.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.playlist.entity.Usuario;
import com.playlist.repository.UsuarioRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!usuarioRepository.findByUsername("admin").isPresent()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // Encriptar contraseña
                admin.setNombre("Administrador");
                admin.setApellido("Del Sistema");
                admin.setEmail("admin@example.com");
                admin.setRol("ROLE_ADMIN");
                usuarioRepository.save(admin); 
            }

            if (!usuarioRepository.findByUsername("user").isPresent()) {
                Usuario user = new Usuario();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123")); // Encriptar contraseña
                user.setNombre("Usuario");
                user.setApellido("Normal");
                user.setEmail("user@example.com");
                user.setRol("ROLE_USER");
                usuarioRepository.save(user);
            }
        };
    }
}
