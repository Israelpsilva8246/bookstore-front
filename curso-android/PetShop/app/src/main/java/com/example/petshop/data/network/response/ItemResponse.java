package com.example.petshop.data.network.response;

import com.squareup.moshi.Json;

public class ItemResponse {

    @Json(name = "name")
    private final String nome;

    @Json(name = "description")
    private final String descricao;

    public ItemResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
