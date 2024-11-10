package com.example.demo.api.controller;

import com.example.demo.api.dto.CategoriaDTO;
import com.example.demo.api.model.CategoriaEntity;
import com.example.demo.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/biblioteca/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/listarTodos")
    public ResponseEntity<List<CategoriaEntity>> listarTodos(){
        List<CategoriaEntity> lista = categoriaService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> categoriaFindById(@PathVariable("id") Long id){
        CategoriaEntity entity = categoriaService.categoriaFindById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/incluir")
    public ResponseEntity<List<CategoriaEntity>> incluir (@RequestBody CategoriaDTO request){
        CategoriaEntity categoriaEntity  = categoriaService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<CategoriaEntity> alterar(@PathVariable long id, @RequestBody CategoriaDTO request) {
        CategoriaEntity lista = categoriaService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = categoriaService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }

}
