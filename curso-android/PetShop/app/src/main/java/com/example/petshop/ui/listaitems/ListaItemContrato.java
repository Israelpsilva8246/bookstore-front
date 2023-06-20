package com.example.petshop.ui.listaitems;

import com.example.retrofit.data.model.Filme;

import java.util.List;

public interface ListaItemContrato {

    interface ListaItemView {

        void mostraItem(List<Item> filmes);

        void mostraErro();

    }

    interface ListaFilmesPresenter {

        void obtemItems();

        void destruirView();
    }
}
