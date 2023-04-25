package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

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
    }
}


