package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.dto.ClienteDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.ClienteEntity;
import com.example.demo.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;


    public List<AutorEntity> listarTodos() {
        return autorRepository.findAll();
    }

    public AutorEntity incluir(AutorDTO dto){
        dto.setNome(dto.getNome());
        dto.setNacionalidade(dto.getNacionalidade());
        AutorEntity entity = AutorEntity.builder()
                .nome(dto.getNome())
        .nacionalidade(dto.getNacionalidade())
                .build();
    return autorRepository.save(entity);
    }

    public AutorEntity alterar(Long id, AutorDTO dto){
        AutorEntity objeto = autorFindById(id);
        objeto.setNome(dto.getNome());
        objeto.setNacionalidade(dto.getNacionalidade());
        return autorRepository.save(objeto);
    }

    public AutorEntity autorFindById(Long id){
        return autorRepository.findById(id).get();
    }

    public ResponseEntity deletar(Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




    }
