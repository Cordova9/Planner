package com.example.eventos.Adaptadores;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EventosHolder extends RecyclerView.ViewHolder {
   ImageView imagen_evento;
   TextView txt_evento;
   CardView cv;
   Context context;
   String id;
    FloatingActionButton favoritos;

    public EventosHolder(@NonNull View itemView,final Context c) {
        super(itemView);
        imagen_evento = itemView.findViewById(R.id.imagen_evento);
        txt_evento = itemView.findViewById(R.id.txt_evento);
        this.context = c;
        cv=itemView.findViewById(R.id.card_view_eventos);
        favoritos = itemView.findViewById(R.id.favoritos);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.get){
                    favoritos.setImageDrawable(c.getDrawable(R.drawable.ic_favorite_blanco));
            }else{
favoritos.setImageDrawable(c.getDrawable(R.drawable.ic_favorite));
            }
        });
    }
    }
}

