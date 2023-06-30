package com.example.petstore_api.response;

import static org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

public class ApiClientTest {

    @Test
    public void getRetrofitClient() {

        ItemService itemService = ApiClient.getRetrofitClient();

        assertNotNull(itemService);
    }
}