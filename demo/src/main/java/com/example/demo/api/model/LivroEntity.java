package com.example.demo.api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private AutorEntity autor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CATEGORIA_ID", nullable = false)
    private CategoriaEntity categoria;
}
