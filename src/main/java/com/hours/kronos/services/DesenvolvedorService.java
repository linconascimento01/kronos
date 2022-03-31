package com.hours.kronos.services;


import com.hours.kronos.models.DesenvolvedorModel;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.repositorys.DesenvolvedorRepository;
import com.hours.kronos.repositorys.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DesenvolvedorService {

    @Autowired
    DesenvolvedorRepository desenvolvedorRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DesenvolvedorModel save(DesenvolvedorModel desenvolvedorModel){
        return desenvolvedorRepository.save(desenvolvedorModel);
    }

    public DesenvolvedorModel findById(Integer desenvolvedorId){
        return desenvolvedorRepository.findById(desenvolvedorId).orElse(null);
    }

    public List<DesenvolvedorModel> findAll(){
        List<DesenvolvedorModel> desenvolvedorModels = new ArrayList<>();

        desenvolvedorRepository.findAll().forEach(desenvolvedorModels::add);

        return desenvolvedorModels;
    }

    public void deleteById(Integer desenvolvedorId){
        desenvolvedorRepository.deleteById(desenvolvedorId);
    }

    public DesenvolvedorModel findByUsuarioId(UsuarioModel usuarioModel){
        return desenvolvedorRepository.findByUsuario(usuarioModel);
    }

}
