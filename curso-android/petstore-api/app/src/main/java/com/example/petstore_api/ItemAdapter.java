package com.example.petstore_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petstore_api.model.Item;
import com.example.petstore_api.model.Post;
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
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Item item;

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

        public void bind(Item item) {
            this.item = item;

            tvName.setText("Nome: " + item.getName());
            tvDescription.setText("Descrição: " + item.getDescription());
            tvPrice.setText("Preço: R$" + item.getPrice());
            Picasso.get()
                    .load("https://8e84-190-111-131-171.ngrok-free.app/" + item.getImageUrl())
                    .into(imageItemView);
        }
    }

}
