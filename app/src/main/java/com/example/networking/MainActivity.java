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

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";
    private ArrayList<Mountain> mountains;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

        // converts json contents to string
        String json = readFile("mountains.json");

        // gson used to deserialize json to list of objects
        Gson gson = new Gson();

        // TypeToken to tell gson to convert to specifically an *arraylist of Mountain objects*
        Type mountainListType = new TypeToken<ArrayList<Mountain>>(){}.getType();
        mountains = gson.fromJson(json, mountainListType);
        recyclerViewAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        };
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }
    @SuppressWarnings("SameParameterValue")
    private String readFile(String fileName) {
        try {
            //noinspection CharsetObjectCanBeUsed
            return new Scanner(getApplicationContext().getAssets().open(fileName), Charset.forName("UTF-8").name()).useDelimiter("\\A").next();
        } catch (IOException e) {
            String TAG = "a21liltr";
            Log.e(TAG, "Could not read file: " + fileName);
            return null;
        }
    }
}


