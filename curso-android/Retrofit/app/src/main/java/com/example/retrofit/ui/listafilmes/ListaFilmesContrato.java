package com.example.retrofit.ui.listaFilmes;

import com.example.retrofit.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();

    }

    interface ListaFilmesPresenter {

        void obtemFilmes();

        void destruirView();
    }
}
