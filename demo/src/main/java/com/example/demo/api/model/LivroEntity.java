package com.example.demo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="TBL_LIVROS")
public class LivroEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LIVRO")
    private Long id;

    @Column(name="TITULO", nullable = false, length = 60)
    private String titulo;

    @Column(name="ISBN", nullable = false, length = 60)
    private String isbn;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="AUTOR_ID", nullable = false)
    @JsonIgnore
    private AutorEntity autor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CATEGORIA_ID", nullable = false)
    @JsonIgnore
    private CategoriaEntity categoria;
}
