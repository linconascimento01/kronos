package com.hours.kronos.services;

import com.hours.kronos.models.PerfilModel;
import com.hours.kronos.repositorys.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public PerfilModel getById(Integer id){
         return perfilRepository.findById(id).orElse(null);
    }

    public List<PerfilModel> getAll(Integer id){
        List<PerfilModel> perfilModels = new ArrayList<>();
        perfilRepository.findAll().forEach(perfilModels::add);
        return perfilModels;
    }
}
