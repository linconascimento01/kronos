package com.hours.kronos.repositorys;

import com.hours.kronos.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {

    UsuarioModel findByEmail(String email);
}
