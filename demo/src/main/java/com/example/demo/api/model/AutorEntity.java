package com.example.demo.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
   // @JsonIgnore
    private List<LivroEntity> livros;
}
