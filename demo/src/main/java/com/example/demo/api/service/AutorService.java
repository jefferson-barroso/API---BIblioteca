package com.example.demo.api.service;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.exception.EntidadeEmUsoException;
import com.example.demo.api.exception.EntidadeNaoEncontradaException;
import com.example.demo.api.model.AutorEntity;
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

    public AutorEntity incluir(AutorDTO dto) {
        if (dto.getNome() == null || dto.getNacionalidade() == null) {
            throw new IllegalArgumentException("Nome e Nacionalidade são obrigatórios");
        }

        AutorEntity entity = AutorEntity.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .build();

        return autorRepository.save(entity);
    }

    public AutorEntity alterar(Long id, AutorDTO dto) {
        AutorEntity objeto = autorFindById(id);
        if (dto.getNome() != null) objeto.setNome(dto.getNome());
        if (dto.getNacionalidade() != null) objeto.setNacionalidade(dto.getNacionalidade());
        return autorRepository.save(objeto);
    }

    public AutorEntity autorFindById(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Autor com ID " + id + " não encontrado"));
    }

    public ResponseEntity<String> deletar(Long id) {
        AutorEntity autor = autorFindById(id);
        try {
            autorRepository.deleteById(id);
            return ResponseEntity.ok("Autor excluído com sucesso.");
        } catch (Exception e) {
            throw new EntidadeEmUsoException("Autor com ID " + id + " não pode ser excluído porque está em uso.");
        }
    }
}
