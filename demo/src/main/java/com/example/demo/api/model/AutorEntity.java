package com.example.demo.api.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_AUTORES")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "AUTOR_ID")
    private Long id;

    @Column(name = "NOME",  nullable = false, length = 60)
    private String nome;

    @Column(name= "NACIONALIDADE", nullable = false, length = 60)
    private String nacionalidade;
}
