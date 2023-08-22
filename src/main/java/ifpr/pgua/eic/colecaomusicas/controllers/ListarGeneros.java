package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.models.Genero;
import ifpr.pgua.eic.colecaomusicas.repositories.RepositorioGeneros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListarGeneros implements Initializable{

    @FXML
    private ListView<Genero> lstGeneros;

    private RepositorioGeneros repositorio;

    public ListarGeneros(RepositorioGeneros repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstGeneros.getItems().clear();
        List<Genero> lista = repositorio.listarGeneros();

        if(lista != null){
            lstGeneros.getItems().addAll(lista);
        }
    
    }

}
