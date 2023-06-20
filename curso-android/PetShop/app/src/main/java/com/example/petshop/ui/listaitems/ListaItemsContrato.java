package com.example.petshop.ui.listaitems;

import com.example.petshop.data.model.Item;

import java.util.List;

public interface ListaItemsContrato {

    interface ListaFilmesView {

        void mostraItem(List<Item> items);

        void mostraErro();

    }

    interface ListaItemsPresenter {

        void obtemItems();

        void destruirView();
    }
}
