package com.example.demo.api.repository;

import com.example.demo.api.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

//    @Query("SELECT c.id, c.nome, c.status FROM ClienteEntity c ORDER BY c.status ASC")
//    public List<ClienteDTO> listarTodos();
}
