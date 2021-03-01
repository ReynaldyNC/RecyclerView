/*
 * Copyright (c) 2021. Reynaldy Nurcahyo
 */

package com.reynaldynurcahyo.projectrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private final ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        rv = findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);

        list.addAll(ItemData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter itemAdapter = new ItemAdapter(list);
        rv.setAdapter(itemAdapter);
    }
}