package com.example.petstore_api.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("title")
    private String titulo;

    @SerializedName("body")
    private String texto;

    public Post(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
