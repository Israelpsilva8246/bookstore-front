package com.example.petshop.ui.listaitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop.R;
import com.example.petshop.data.model.Item;
import com.example.petshop.data.network.response.ItemResponse;

import java.util.List;

public class ListaItemAdapter extends RecyclerView.Adapter<ListaItemAdapter.ListaItemViewHolder> {

    private List<ItemResponse> items;

    public ListaItemAdapter(List<ItemResponse> items) {
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
        holder.txtNomeItem.setText(items.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ListaItemViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNomeItem;
        private Item item;

        public ListaItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNomeItem = itemView.findViewById(R.id.txt_name_item);

        }

        public void bind(Item item) {
            this.item = item;

            txtNomeItem.setText(item.getName());

        }

    }
}
