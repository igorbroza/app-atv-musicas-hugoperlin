package ifpr.pgua.eic.colecaomusicas;

import ifpr.pgua.eic.colecaomusicas.controllers.CadastroArtista;
import ifpr.pgua.eic.colecaomusicas.controllers.CadastroGenero;
import ifpr.pgua.eic.colecaomusicas.controllers.Principal;
import ifpr.pgua.eic.colecaomusicas.models.Repositorio;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private Repositorio repositorio = new Repositorio();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Coleção de Músicas";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));
        registraTela("CADASTROGENERO",
                  new ScreenRegistryFXML(App.class, 
                      "cadastrar_genero.fxml", 
                      o->new CadastroGenero(repositorio)
                  )
        );
        registraTela("CADASTROARTISTA",
                  new ScreenRegistryFXML(App.class, 
                      "cadastrar_artista.fxml", 
                      o->new CadastroArtista(repositorio)
                  )
        );
    }

}