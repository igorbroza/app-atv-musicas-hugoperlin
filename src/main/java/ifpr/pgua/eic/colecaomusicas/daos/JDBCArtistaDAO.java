package ifpr.pgua.eic.colecaomusicas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.models.Artista;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;


public class JDBCArtistaDAO implements ArtistaDAO {

    private FabricaConexoes fabrica;

    public JDBCArtistaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Artista artista) {
        try{

            Connection con = fabrica.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO artistas(nome,contato) VALUES (?)");
            
            pstm.setString(1, artista.getNome());

            int ret = pstm.executeUpdate();

            con.close();

            if(ret == 1) {
                return Resultado.sucesso("Artista Cadastrado", artista);
            }
            return Resultado.erro("Erro Nao identificado");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listar() {
        try {
            Connection con = fabrica.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM artistas");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Artista> lista = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String contato = rs.getString("contato");

                Artista artista = new Artista(id, nome, contato);
                lista.add(artista);
            }
            rs.close();
            pstm.close();
            con.close();

            return Resultado.sucesso("Artista Cadastrado", lista);
        } catch (SQLException e){
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Resultado atualizar(int id, Artista novo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
    
}
