package com.hours.kronos.repositorys;

import com.hours.kronos.models.DesenvolvedorModel;
import com.hours.kronos.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends CrudRepository<DesenvolvedorModel, Integer> {

    DesenvolvedorModel findByUsuario(UsuarioModel usuarioId);
}
