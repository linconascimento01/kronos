package com.hours.kronos.repositorys;

import com.hours.kronos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UsuarioModel findByEmailAndSenha(String email, String Senha);

    Optional<UsuarioModel> findByEmail(String email);
//    List<UsuarioModel> findByPerfil(Integer perfil);
}
