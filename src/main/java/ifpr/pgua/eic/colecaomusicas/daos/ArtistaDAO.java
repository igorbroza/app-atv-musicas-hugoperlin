package ifpr.pgua.eic.colecaomusicas.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.models.Artista;

public interface ArtistaDAO {
    //c
    Resultado criar(Artista artista);

    //r
    Resultado listar();

    //u
    Resultado atualizar(int id, Artista novo);

    //d
    Resultado delete(int id);
}
