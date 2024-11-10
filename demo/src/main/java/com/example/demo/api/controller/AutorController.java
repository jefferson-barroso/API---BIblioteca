package com.example.demo.api.controller;

import com.example.demo.api.dto.AutorDTO;
import com.example.demo.api.dto.ClienteDTO;
import com.example.demo.api.model.AutorEntity;
import com.example.demo.api.model.ClienteEntity;
import com.example.demo.api.service.AutorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/biblioteca/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/listarTodos")
    public ResponseEntity<List<AutorEntity>> listarTodos(){
        List<AutorEntity> lista = autorService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> autorFindById(@PathVariable("id") Long id){
        AutorEntity entity = autorService.autorFindById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping(value="/incluir")
    public ResponseEntity<List<AutorEntity>> incluir (@RequestBody AutorDTO request){
        AutorEntity autorEntity  = autorService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<AutorEntity> alterar(@PathVariable long id, @RequestBody AutorDTO request) {
        AutorEntity lista = autorService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = autorService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }


}
