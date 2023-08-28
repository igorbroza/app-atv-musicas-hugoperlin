package ifpr.pgua.eic.colecaomusicas.controllers;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.repositories.RepositorioArtistas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroArtista {

    @FXML
    private TextField tfContato;

    @FXML
    private TextField tfNome;

    private RepositorioArtistas repositorio;

    public CadastroArtista(RepositorioArtistas repositorio){
        this.repositorio = repositorio;
    }


    @FXML
    void cadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        String contato = tfContato.getText();

        String msg = repositorio.cadastrarArtista(nome, contato);

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();
    }

    @FXML
    void cancelar(ActionEvent event) {
        App.popScreen();
    }

}
