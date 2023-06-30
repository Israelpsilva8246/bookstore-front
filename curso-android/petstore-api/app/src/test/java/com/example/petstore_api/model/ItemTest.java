package com.example.petstore_api.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

    @Test
    public void testItem() {
        // Criação de um item de exemplo
        String name = "Item 1";
        String description = "Descrição do item 1";
        double price = 10.99;
        String imageUrl = "https://example.com/item1.jpg";
        Item item = new Item(name, description, price, imageUrl);

        // Verificação dos valores dos atributos
        assertEquals(name, item.getName());
        assertEquals(description, item.getDescription());
        assertEquals(price, item.getPrice(), 0.01); // Verificar com uma tolerância de 0.01 devido à precisão de double
        assertEquals(imageUrl, item.getImageUrl());

        // Modificação dos valores dos atributos
        String newName = "Item 1 modificado";
        String newDescription = "Nova descrição do item 1";
        double newPrice = 19.99;
        String newImageUrl = "https://example.com/item1_modified.jpg";

        item.setName(newName);
        item.setDescription(newDescription);
        item.setPrice(newPrice);
        item.setImageUrl(newImageUrl);

        // Verificação dos valores modificados dos atributos
        assertEquals(newName, item.getName());
        assertEquals(newDescription, item.getDescription());
        assertEquals(newPrice, item.getPrice(), 0.01); // Verificar com uma tolerância de 0.01 devido à precisão de double
        assertEquals(newImageUrl, item.getImageUrl());
    }
}