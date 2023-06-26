package com.example.petstore_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petstore_api.model.Item;
import com.example.petstore_api.model.Post;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;

    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.itemList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        Item item = itemList.get(position);
        holder.idTxt.setText("id: " + item.getId() + "\n");
        holder.nameTxt.setText("name: " + item.getName() + "\n");
        holder.descriptionTxt.setText("description: " + item.getDescription() + "\n");
        holder.priceTxt.setText("price: " + String.valueOf(item.getPrice()) + "\n");
        holder.imageUrlTxt.setText("imagem: " + item.getImage_url() + "\n");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idTxt, nameTxt, descriptionTxt, priceTxt, imageUrlTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTxt = itemView.findViewById(R.id.id_txt);
            nameTxt = itemView.findViewById(R.id.name_txt);
            descriptionTxt = itemView.findViewById(R.id.description_txt);
            priceTxt = itemView.findViewById(R.id.price_txt);
            imageUrlTxt = itemView.findViewById(R.id.image_url_txt);
        }
    }
}
