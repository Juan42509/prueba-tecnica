package com.playlist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.configuration.JwtUtil;
import com.playlist.entity.JwtRequest;
import com.playlist.entity.JwtResponse;
import com.playlist.entity.Usuario;
import com.playlist.exceptions.UsuarioNotFoundException;
import com.playlist.repository.UsuarioRepository;
import com.playlist.serviceImpl.UserDetailsServiceImpl;

@RestController
@RequestMapping("*")
@CrossOrigin("*")
public class AuthController {
	
    
    @Autowired
    private AuthenticationManager anthenticationManager;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JwtUtil jwtUtils;
    
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsuarioNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void autenticar(String username, String password) throws Exception{
        try {
            anthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("Usuario Deshabilitado " + e.getMessage());
        }catch(BadCredentialsException b){
            throw new Exception("Credenciales Invalidas " + b.getMessage());
        }
    }
    
    @GetMapping("/actual-usuario")
    public ResponseEntity<?> ObtenerUsuarioActual(Principal principal) {
        Usuario usuario = usuarioRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return ResponseEntity.ok(usuario); // Devuelve el objeto Usuario correctamente
    }
    
}
