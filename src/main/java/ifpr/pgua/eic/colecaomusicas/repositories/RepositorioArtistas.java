package ifpr.pgua.eic.colecaomusicas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;

public class RepositorioArtistas {
    
    private ArrayList<Artista> artistas;

    private FabricaConexoes fabrica;

    public RepositorioArtistas(FabricaConexoes fabrica){
        artistas = new ArrayList<>();
        this.fabrica = fabrica;
    }

    public String cadastrarArtista(String nome, String contato){
        try{
            Connection con = fabrica.getConnection();
            //Preparar o comando sql
            PreparedStatement pstm = con.
            prepareStatement("INSERT INTO artistas(nome,contato) VALUES (?,?)");
            //Ajustar os parâmetros
            pstm.setString(1,nome);
            pstm.setString(2, contato);
            //Executar o comando
            int ret = pstm.executeUpdate();

            con.close();
            if(ret == 1){
                return "Artista cadastrado!";
            }
            return "Deu ruim!!";
        }catch(SQLException e){
            return e.getMessage();
        }
    }

}
