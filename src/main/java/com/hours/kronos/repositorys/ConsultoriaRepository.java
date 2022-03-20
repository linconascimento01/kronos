package com.hours.kronos.repositorys;

import com.hours.kronos.models.ConsultoriaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultoriaRepository extends CrudRepository<ConsultoriaModel, Integer> {
}
