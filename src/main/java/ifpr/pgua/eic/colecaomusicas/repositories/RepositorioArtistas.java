package ifpr.pgua.eic.colecaomusicas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.daos.ArtistaDAO;
import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;

public class RepositorioArtistas {
    
    private ArtistaDAO dao;

    public RepositorioArtistas(ArtistaDAO dao){
        new ArrayList<>();
        this.dao = dao;
    }

    public String cadastrarArtista(String nome, String contato){
        Artista artista = new Artista(nome, contato);
        Resultado resultado = dao.criar(artista);
        return resultado.getMsg();
    }

    public List<Artista> listarArtistas(){
        Resultado resultado = dao.listar();

        if(resultado.foiSucesso()){
            return (ArrayList)resultado.comoSucesso().getObj();
        }
        return null;
    }

}
