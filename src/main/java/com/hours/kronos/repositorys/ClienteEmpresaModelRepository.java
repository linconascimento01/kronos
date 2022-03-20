package com.hours.kronos.repositorys;

import com.hours.kronos.models.ClienteEmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteEmpresaModelRepository extends JpaRepository<ClienteEmpresaModel, Integer> {
}