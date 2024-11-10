package com.example.demo.api.service;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.repository.AutorRepository;
import com.example.demo.api.repository.CategoriaRepository;
import com.example.demo.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<LivroEntity> listarTodos() {
        return livroRepository.findAll();
    }

    public LivroEntity incluir(LivroDTO dto) {
        AutorEntity autor = autorRepository.findById(dto.getAutor_id())
                .orElseThrow(() -> new NoSuchElementException("Autor com ID " + dto.getAutor_id() + " não encontrado"));

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoria_id())
                .orElseThrow(() -> new NoSuchElementException("Categoria com ID " + dto.getCategoria_id() + " não encontrada"));

        LivroEntity entity = LivroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(autor)
                .categoria(categoria)
                .build();

        return livroRepository.save(entity);
    }

    public LivroEntity alterar(Long id, LivroDTO dto) {
        LivroEntity objeto = livroFindById(id);

        AutorEntity autor = autorRepository.findById(dto.getAutor_id())
                .orElseThrow(() -> new NoSuchElementException("Autor com ID " + dto.getAutor_id() + " não encontrado"));

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoria_id())
                .orElseThrow(() -> new NoSuchElementException("Categoria com ID " + dto.getCategoria_id() + " não encontrada"));

        objeto.setTitulo(dto.getTitulo());
        objeto.setIsbn(dto.getIsbn());
        objeto.setAutor(autor);
        objeto.setCategoria(categoria);

        return livroRepository.save(objeto);
    }

    public LivroEntity livroFindById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Livro com ID " + id + " não encontrado"));
    }

    public ResponseEntity<Void> deletar(Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
