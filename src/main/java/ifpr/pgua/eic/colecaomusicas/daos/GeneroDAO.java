package ifpr.pgua.eic.colecaomusicas.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.models.Genero;

public interface GeneroDAO {
    //c
    Resultado criar(Genero genero);

    //r
    Resultado listar();

    //u
    Resultado atualizar(int id, Genero novo);

    //d
    Resultado delete(int id);
}
