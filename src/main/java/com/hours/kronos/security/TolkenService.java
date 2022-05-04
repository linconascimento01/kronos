package com.hours.kronos.security;

import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.models.UsuarioModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TolkenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.time.expiration}")
    private String expiration;

    public String gerarTolken(Authentication dadosLogin) {
        UsuarioModel usuario = (UsuarioModel) dadosLogin.getPrincipal();
        Date hoje = new Date();
        Date dataExpiração = new Date(hoje.getTime() + Long.parseLong(this.expiration));

        System.out.println(this.expiration);
        System.out.println(this.secret);

        return Jwts.builder()
                .setIssuer("api")
                .setSubject(usuario.getUsuarioId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiração)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validarTolken(String tolken) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(tolken);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String tolken) {
     Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(tolken).getBody();
     return Long.parseLong(claims.getSubject());
    }
}
