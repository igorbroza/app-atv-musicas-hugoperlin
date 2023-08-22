package ifpr.pgua.eic.colecaomusicas;

import ifpr.pgua.eic.colecaomusicas.controllers.CadastroArtista;
import ifpr.pgua.eic.colecaomusicas.controllers.CadastroGenero;
import ifpr.pgua.eic.colecaomusicas.controllers.ListarGeneros;
import ifpr.pgua.eic.colecaomusicas.controllers.Principal;
import ifpr.pgua.eic.colecaomusicas.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.daos.JDBCGeneroDAO;
import ifpr.pgua.eic.colecaomusicas.models.FabricaConexoes;
import ifpr.pgua.eic.colecaomusicas.repositories.RepositorioArtistas;
import ifpr.pgua.eic.colecaomusicas.repositories.RepositorioGeneros;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private RepositorioArtistas repositorioArtistas = new RepositorioArtistas(FabricaConexoes.getInstance());
    private GeneroDAO generoDAO = new JDBCGeneroDAO(FabricaConexoes.getInstance());
    private RepositorioGeneros repositorioGeneros = new RepositorioGeneros(generoDAO);

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
                      o->new CadastroGenero(repositorioGeneros)
                  )
        );
        registraTela("LISTARGENEROS",
                  new ScreenRegistryFXML(App.class, 
                      "listar_generos.fxml", 
                      o->new ListarGeneros(repositorioGeneros)
                  )
        );
        registraTela("CADASTROARTISTA",
                  new ScreenRegistryFXML(App.class, 
                      "cadastrar_artista.fxml", 
                      o->new CadastroArtista(repositorioArtistas)
                  )
        );
    }

}