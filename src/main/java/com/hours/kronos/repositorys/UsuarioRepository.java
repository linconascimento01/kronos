package com.hours.kronos.repositorys;

import com.hours.kronos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    UsuarioModel findByEmailAndSenha(String email, String Senha);
//    List<UsuarioModel> findByPerfil(Integer perfil);
}
