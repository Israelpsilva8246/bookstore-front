package com.example.retrofit.data.model;

import java.io.Serializable;

public class Filme implements Serializable {

    private final String titulo;

    private final String caminhoPoster;

    public Filme(String nome, String caminhoPoster) {
        this.titulo = nome;
        this.caminhoPoster = caminhoPoster;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
