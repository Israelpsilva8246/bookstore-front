package com.example.petshop.ui.listaitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop.R;
import com.example.petshop.model.Item;

import java.util.List;

public class ListaItemAdapter extends RecyclerView.Adapter<ListaItemAdapter.ListaItemViewHolder> {

    private final List<Item> items;


    public ListaItemAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListaItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_view, parent, false
        );
        return new ListaItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ListaItemViewHolder extends RecyclerView.ViewHolder {

        private TextView txtItem;

        private Item item;

        public ListaItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtItem = itemView.findViewById(R.id.txt_item);

        }

        public void bind(Item item) {
            this.item = item;

            txtItem.setText(item.getName());
        }

    }
}
