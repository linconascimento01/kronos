package com.hours.kronos.repositorys;

import com.hours.kronos.models.PerfilModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<PerfilModel, Integer> {
}
