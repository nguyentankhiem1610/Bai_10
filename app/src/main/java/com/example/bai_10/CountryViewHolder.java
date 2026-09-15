package com.example.bai_10;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    public TextView countryName;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        countryName = itemView.findViewById(R.id.countryName);
    }
}
