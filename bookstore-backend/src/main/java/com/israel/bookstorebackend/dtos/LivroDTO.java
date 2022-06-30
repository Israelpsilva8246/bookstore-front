package com.israel.bookstorebackend.dtos;

import com.israel.bookstorebackend.domain.Livro;
import lombok.Data;

import java.io.Serializable;

@Data
public class LivroDTO implements Serializable {

    private Long id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
