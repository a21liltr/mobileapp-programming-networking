package com.example.networking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, IRecyclerView {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json"; // Not used.
    private ArrayList<Mountain> mountains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        // gson used to deserialize json to list of objects
        Gson gson = new Gson();

        // TypeToken to tell gson to convert to specifically an *arraylist of Mountain objects*
        Type mountainListType = new TypeToken<ArrayList<Mountain>>(){}.getType();
        mountains = gson.fromJson(json, mountainListType);

        for (Mountain m : mountains) {
            Log.d("a21liltr", m.toString());
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, mountains, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("keyName", mountains.get(position).getName());
        intent.putExtra("keyInfo", mountains.get(position).info());

        startActivity(intent);
    }
}


