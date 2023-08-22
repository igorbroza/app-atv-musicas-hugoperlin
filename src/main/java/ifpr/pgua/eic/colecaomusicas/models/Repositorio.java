package ifpr.pgua.eic.colecaomusicas.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    
    private ArrayList<Genero> generos;
    private ArrayList<Artista> artistas;

    public Repositorio(){
        generos = new ArrayList<>();
        artistas = new ArrayList<>();
    }

    public String cadastrarGenero(String nome){
        
        //Salvar o nome na tabela generos no banco de dados
        
        //Conectar no banco
        //String url = "jdbc:mysql://localhost/musicas"; //local
        try{
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo"; //local root
            String password = "1234"; //local ""
            Connection con = DriverManager.getConnection(url,username,password);
            //Preparar o comando sql
            PreparedStatement pstm = con.
            prepareStatement("INSERT INTO generos(nome) VALUES (?)");
            //Ajustar os parâmetros
            pstm.setString(1,nome);
            //Executar o comando
            int ret = pstm.executeUpdate();

            if(ret == 1){
                return "Genero cadastrado!";
            }
            return "Deu ruim!!";
        }catch(SQLException e){
            return e.getMessage();
        } 
    }

    public List<Genero> listarGeneros(){
        try{
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo"; //local root
            String password = "1234"; //local ""
            Connection con = DriverManager.getConnection(url,username,password);
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM generos");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Genero> lista = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Genero genero = new Genero(id, nome);
                lista.add(genero);
            }
            rs.close();
            pstm.close();
            con.close();

            return lista;
        }catch(SQLException e){
            System.out.println("Problema na consulta!! "+e.getMessage());
            return null;
        }
    }

    public String cadastrarArtista(String nome, String contato){
        try{
            String url = "jdbc:mysql://wagnerweinert.com.br:3306/hugo";
            String username = "hugo"; //local root
            String password = "1234"; //local ""
            Connection con = DriverManager.getConnection(url,username,password);
            //Preparar o comando sql
            PreparedStatement pstm = con.
            prepareStatement("INSERT INTO artistas(nome,contato) VALUES (?,?)");
            //Ajustar os parâmetros
            pstm.setString(1,nome);
            pstm.setString(2, contato);
            //Executar o comando
            int ret = pstm.executeUpdate();

            if(ret == 1){
                return "Artista cadastrado!";
            }
            return "Deu ruim!!";
        }catch(SQLException e){
            return e.getMessage();
        }
    }

}
