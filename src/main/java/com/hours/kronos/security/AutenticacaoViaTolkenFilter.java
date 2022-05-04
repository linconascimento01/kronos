package com.hours.kronos.security;

import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.repositorys.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class AutenticacaoViaTolkenFilter extends OncePerRequestFilter {

    private TolkenService tolkenService;
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String tolken = recuperarTolken(request);
        boolean valido = tolkenService.validarTolken(tolken);

        if (valido){
            autenticarCliente(tolken);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String tolken) {
        Long idUsuario = tolkenService.getIdUsuario(tolken);
        UsuarioModel usuario = usuarioRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication
                = new UsernamePasswordAuthenticationToken(usuario , null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarTolken(HttpServletRequest request) {
        String tolken = request.getHeader("Authorization");
        if(tolken == null || !tolken.startsWith("Bearer")){
            return null;
        }
        return tolken.substring(7);
    }
}
