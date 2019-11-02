package com.example.eventos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventosInterface {
@GET("Eventos/")
    Call<List<Item_eventos>> ListarEventos();

}
