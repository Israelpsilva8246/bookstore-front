package com.example.retrofit.ui.listaFilmes;

import com.example.retrofit.data.mapper.FilmeMapper;
import com.example.retrofit.data.model.Filme;
import com.example.retrofit.data.network.ApiService;
import com.example.retrofit.data.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().obterFilmesPopulares("7e72c3fb4901cd249ae166a927aa1e77")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());
                            view.mostraFilmes(listaFilmes);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
