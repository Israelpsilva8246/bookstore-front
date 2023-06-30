package com.example.petstore_api.activity;

import static org.junit.Assert.assertEquals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.petstore_api.R;
import com.example.petstore_api.model.Item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ItemAdapterTest {
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Before
    public void setUp() {
        // Criação da lista de itens de exemplo
        itemList = new ArrayList<>();
        itemList.add(new Item("Item 1", "Descrição do Item 1", 10.99, "https://example.com/item1.jpg"));
        itemList.add(new Item("Item 2", "Descrição do Item 2", 19.99, "https://example.com/item2.jpg"));

        // Criação do adapter com a lista de itens
        adapter = new ItemAdapter(itemList);
    }

    @Test
    public void testOnBindViewHolder() {
        // Criação de um ViewGroup simulado para testes
        ViewGroup parent = new RecyclerView(RuntimeEnvironment.application);

        // Criação de uma itemView simulada para testes
        View itemView = LayoutInflater.from(RuntimeEnvironment.application).inflate(R.layout.singleview, parent, false);

        // Criação de um ViewHolder com a itemView simulada
        ItemAdapter.ViewHolder viewHolder = adapter.new ViewHolder(itemView);

        // Posição do item a ser testado
        int position = 0;

        // Chama o método onBindViewHolder do adapter
        adapter.onBindViewHolder(viewHolder, position);

        // Verifica se os dados foram corretamente exibidos nas visualizações do ViewHolder
        TextView tvName = itemView.findViewById(R.id.tvName);
        assertEquals(itemList.get(position).getName(), tvName.getText().toString());

        TextView tvDescription = itemView.findViewById(R.id.tvDescription);
        assertEquals(itemList.get(position).getDescription(), tvDescription.getText().toString());

        TextView tvPrice = itemView.findViewById(R.id.tvPrice);
        assertEquals("R$: " + itemList.get(position).getPrice(), tvPrice.getText().toString());
    }


}
