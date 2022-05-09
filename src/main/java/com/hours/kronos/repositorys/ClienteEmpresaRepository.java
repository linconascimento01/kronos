package com.hours.kronos.repositorys;

import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.ConsultoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteEmpresaRepository extends JpaRepository<ClienteEmpresaModel, Integer> {
    List<ClienteEmpresaModel> findByConsultoriaAndFlagConsultoria(ConsultoriaModel consultoriaModel, Boolean flag);
}