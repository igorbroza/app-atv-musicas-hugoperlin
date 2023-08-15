package ifpr.pgua.eic.colecaomusicas.models;

import java.util.ArrayList;

public class Repositorio {
    
    private ArrayList<Genero> generos;
    private ArrayList<Artista> artistas;

    public Repositorio(){
        generos = new ArrayList<>();
        artistas = new ArrayList<>();
    }

    public String cadastrarGenero(String nome){
        Genero genero = new Genero(nome);

        generos.add(genero);

        return "Genero cadastrado!";
    }

    public String cadastrarArtista(String nome, String contato){
        Artista artista = new Artista(nome, contato);

        artistas.add(artista);

        return "Artista cadastrado!";
    }

}
