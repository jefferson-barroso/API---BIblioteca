package com.example.demo.api.service;

import com.example.demo.api.dto.ClienteDTO;
import com.example.demo.api.model.ClienteEntity;
import com.example.demo.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> listarTodos(){
        return clienteRepository.findAll();
    }
    public ClienteEntity incluir(ClienteDTO dto){
        dto.setNome(dto.getNome());
        dto.setStatus(dto.getStatus());
        ClienteEntity entity = ClienteEntity.builder()
                .nome(dto.getNome())
                .status(dto.getStatus())
                .build();
        return clienteRepository.save(entity);

    }
    public ClienteEntity alterar(Integer id, ClienteDTO dto){

        ClienteEntity objeto  = clienteFindById(id);
        objeto.setNome(dto.getNome());
        objeto.setStatus(dto.getStatus());
        return clienteRepository.save(objeto);
    }
    public ResponseEntity deletar(Integer id) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
    }

    public ClienteEntity clienteFindById(Integer id) {
        return clienteRepository.findById(id).get();
    }


}
