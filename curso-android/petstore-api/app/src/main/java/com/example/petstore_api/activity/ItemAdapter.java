package com.example.petstore_api.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petstore_api.R;
import com.example.petstore_api.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);

        String nome = item.getName();
        String descricao = item.getDescription();
        double preco = item.getPrice();
        String imageUrl = item.getImageUrl();

        holder.tvName.setText(nome);
        holder.tvDescription.setText(descricao);
        holder.tvPrice.setText("R$: " + preco);
        Picasso.get().load(imageUrl).into(holder.imageItemView);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Item item;

        TextView tvName;
        TextView tvDescription;
        TextView tvPrice;
        ImageView imageItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imageItemView = itemView.findViewById(R.id.ivImageUrl);
        }

    }

}
