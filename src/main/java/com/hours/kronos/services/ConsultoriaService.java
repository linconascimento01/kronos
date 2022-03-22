package com.hours.kronos.services;

import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.repositorys.ConsultoriaRepository;
import com.hours.kronos.repositorys.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ConsultoriaService {

    @Autowired
    ConsultoriaRepository consultoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ConsultoriaModel save(ConsultoriaModel consultoriaModel){
        return consultoriaRepository.save(consultoriaModel);
    }

    public ConsultoriaModel findById(Integer id){
        return consultoriaRepository.findById(id).orElse(null);
    }

    public List<ConsultoriaModel> findAll(){
        List<ConsultoriaModel> consultorias = new ArrayList<>();
        consultoriaRepository.findAll().forEach(consultorias::add);
        return consultorias;
    }

    public void deleteById(Integer id){
        consultoriaRepository.deleteById(id);
    }


}
