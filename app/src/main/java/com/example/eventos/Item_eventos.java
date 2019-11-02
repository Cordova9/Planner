package com.example.eventos;

public class Item_eventos {
    String id;
    String imagen_evento;
    String txt_evento;

    public Item_eventos(String id, String imagen_evento, String txt_evento) {
        this.id = id;
        this.imagen_evento = imagen_evento;
        this.txt_evento = txt_evento;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getImagen_evento() { return imagen_evento; }

    public void setImagen_evento(String imagen_evento) { this.imagen_evento = imagen_evento; }

    public String getTxt_evento() { return txt_evento; }

    public void setTxt_evento(String txt_evento) { this.txt_evento = txt_evento; }
}
