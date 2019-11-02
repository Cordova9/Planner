package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.eventos.Adaptadores.EventosAdaptador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Eventos extends AppCompatActivity {
    TextView textView;
    RecyclerView recycler_evento;
    List<Item_eventos> artistas_data;
    SearchView search;
    FloatingActionButton favoritos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        textView = findViewById(R.id.textView);
        search = findViewById(R.id.search);
        recycler_evento = findViewById(R.id.recycler_eventos);
        favoritos = findViewById(R.id.favoritos);


        artistas_data = new ArrayList<>();
        artistas_data.add(new Item_eventos("1", "", "Bodas"));
        artistas_data.add(new Item_eventos("2","","Cumpleaños"));
        artistas_data.add(new Item_eventos("3", "", "Dspedida Solteros"));
        artistas_data.add(new Item_eventos("4", "", "Baby Shower"));
favoritos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        
    }
});
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                List<Item_eventos> a = new ArrayList<>();
                for (Item_eventos eventos : artistas_data){
                    if(eventos.txt_evento.toLowerCase().contains(newText)){
                        a.add(eventos);
                    }
                }
                EventosAdaptador adaptador = new EventosAdaptador(Eventos.this, R.layout.item_eventos, a);
                recycler_evento.setAdapter(adaptador);
                recycler_evento.setLayoutManager(new LinearLayoutManager(Eventos.this));
                return false;
            }
        });


        EventosAdaptador adaptador = new EventosAdaptador(this,R.layout.item_eventos,artistas_data);
        recycler_evento.setAdapter(adaptador);
        recycler_evento.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.251:8000/polls/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EventosInterface servicios = retrofit.create(EventosInterface.class);
        Call<List<Item_eventos>> call = servicios.ListarEventos();
        call.enqueue(new Callback<List<Item_eventos>>() {
            @Override
            public void onResponse(Call<List<Item_eventos>> call, Response<List<Item_eventos>> response) {
                Log.e("Eventos",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<Item_eventos>> call, Throwable t) {
                Log.e("Error",t.toString());

            }
        });


    }
    }
