package com.example.retrofit.ui.listafilmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.data.model.Filme;
import com.example.retrofit.network.response.FilmesResponse;

import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<FilmesResponse> filmes;

    public ListaFilmesAdapter(List<FilmesResponse> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.txtTituloFilme.setText(filmes.get(position).getTituloOriginal());
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTituloFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTituloFilme = itemView.findViewById(R.id.txt_Titulo_Filme);

        }
    }
}
