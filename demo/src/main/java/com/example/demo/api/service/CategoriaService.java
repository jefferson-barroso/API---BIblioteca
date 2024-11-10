package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<CategoriaEntity> listarTodos() {
        return categoriaRepository.findAll();
    }

    public CategoriaEntity incluir(CategoriaDTO dto){
        dto.setNome(dto.getNome());
        CategoriaEntity entity = CategoriaEntity.builder()
                .nome(dto.getNome())
                .build();
        return categoriaRepository.save(entity);
    }

    public CategoriaEntity alterar(Long id, CategoriaDTO dto){
        CategoriaEntity objeto = categoriaFindById(id);
        objeto.setNome(dto.getNome());
        return categoriaRepository.save(objeto);
    }

    public CategoriaEntity categoriaFindById(Long id){
        return categoriaRepository.findById(id).get();
    }

    public ResponseEntity deletar(Long id) {
        categoriaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
