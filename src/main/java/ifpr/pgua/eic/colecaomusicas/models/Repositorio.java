package ifpr.pgua.eic.colecaomusicas.models;

import java.util.ArrayList;

public class Repositorio {
    
    private ArrayList<Genero> generos;

    public Repositorio(){
        generos = new ArrayList<>();
    }

    public String cadastrarGenero(String nome){
        Genero genero = new Genero(nome);

        generos.add(genero);

        return "Genero cadastrado!";
    }

}
