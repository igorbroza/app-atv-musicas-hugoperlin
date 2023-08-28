package ifpr.pgua.eic.colecaomusicas.repositories;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.Genero;

public class RepositorioGeneros {
    
    private GeneroDAO dao;

    public RepositorioGeneros(GeneroDAO dao){
        new ArrayList<>();
        this.dao = dao;
    }

    public String cadastrarGenero(String nome){
        Genero genero = new Genero(nome);
        Resultado resultado = dao.criar(genero);
        return resultado.getMsg();
    }

    public List<Genero> listarGeneros(){
        Resultado resultado = dao.listar();

        if(resultado.foiSucesso()){
            return (ArrayList)resultado.comoSucesso().getObj();
        }
        return null;
    }


}
