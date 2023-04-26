package com.example.networking;

import static com.example.networking.MyRecyclerViewAdapter.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Mountain> mountains;
    private LayoutInflater layoutInflater;

    public MyRecyclerViewAdapter(Context c, ArrayList<Mountain> m) {
        this.layoutInflater = LayoutInflater.from(c);
        this.mountains = m;
    }
    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is were the layout is inflated (giving the look of the items/rows)
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new MyRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        // This is were values are assigned to the views created in recycler_view_item layout file
        // based on the position of the recycler view
        holder.tvName.setText(mountains.get(position).getName());
        holder.tvLocation.setText(mountains.get(position).getLocation());
        holder.tvHeight.setText(String.valueOf(mountains.get(position).getHeight()) + " m");
    }

    @Override
    public int getItemCount() {
        // The number of items that is to be displayed
        return mountains.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Assign variables to the views from the recycler_view_item layout file
        TextView tvName, tvLocation, tvHeight;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvHeight = itemView.findViewById(R.id.tv_height);
        }
    }
}
