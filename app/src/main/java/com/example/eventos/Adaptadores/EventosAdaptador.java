package com.example.eventos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eventos.Item_eventos;
import com.example.eventos.R;

import java.util.List;

public class EventosAdaptador extends RecyclerView.Adapter<EventosHolder>  {
    LayoutInflater inflater;
    List<Item_eventos> data;
    Context context;
    int layout;


    public EventosAdaptador(Context context,int layout, List<Item_eventos> data) {
        inflater = LayoutInflater.from(context);
        this.layout=layout;
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public EventosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(layout,parent,false);
        return new EventosHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull EventosHolder holder, int position) {
   holder.txt_evento.setText(data.get(position).getTxt_evento());
        Glide.with(context).load(data.get(position).getImagen_evento()).into(holder.imagen_evento);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
