package ifpr.pgua.eic.colecaomusicas;

import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

public class IniciaDB {
    
    public static void main(String[] args) throws Exception {
        
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3306); 
        //Descomentar para armazenar os dados do banco de forma permanente
        configBuilder.setDataDir("db");

        DB db = DB.newEmbeddedDB(configBuilder.build());
    


        db.start();

        System.out.println("Creating DB");
        
        db.createDB("musicas");

        System.out.println("Loading SQLs");
        db.source("ifpr/pgua/eic/colecaomusicas/sqls/init.sql");

        System.out.println("Ready...");

    }


}
