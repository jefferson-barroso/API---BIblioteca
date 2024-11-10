package com.example.demo.api.service;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.exception.EntidadeEmUsoException;
import com.example.demo.api.exception.EntidadeNaoEncontradaException;
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

    public CategoriaEntity incluir(CategoriaDTO dto) {
        if (dto.getNome() == null) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório");
        }

        CategoriaEntity entity = CategoriaEntity.builder()
                .nome(dto.getNome())
                .build();

        return categoriaRepository.save(entity);
    }

    public CategoriaEntity alterar(Long id, CategoriaDTO dto) {
        CategoriaEntity objeto = categoriaFindById(id);
        if (dto.getNome() != null) objeto.setNome(dto.getNome());
        return categoriaRepository.save(objeto);
    }

    public CategoriaEntity categoriaFindById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria com ID " + id + " não encontrada"));
    }

    public ResponseEntity<String> deletar(Long id) {
        CategoriaEntity categoria = categoriaFindById(id);
        try {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok("Categoria excluída com sucesso.");
        } catch (Exception e) {
            throw new EntidadeEmUsoException("Categoria com ID " + id + " não pode ser excluída porque está em uso.");
        }
    }
}

