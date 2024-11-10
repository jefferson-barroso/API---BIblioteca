package com.example.demo.api.controller;

import com.example.demo.api.dto.LivroDTO;
import com.example.demo.api.model.LivroEntity;
import com.example.demo.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/biblioteca/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listarTodos")
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        List<LivroEntity> lista = livroService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroEntity> livroFindById(@PathVariable("id") Long id) {
        LivroEntity entity = livroService.livroFindById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Void> incluir(@RequestBody LivroDTO request) {
        LivroEntity livroEntity = livroService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<LivroEntity> alterar(@PathVariable Long id, @RequestBody LivroDTO request) {
        LivroEntity entity = livroService.alterar(id, request);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }
}