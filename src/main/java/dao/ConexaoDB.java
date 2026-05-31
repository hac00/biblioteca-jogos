package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca-jogos";
    private static final String USER = "postgres";
    private static final String PSWD = "1234";

    public static Connection getConexao(){

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PSWD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco");
            e.printStackTrace();
        }
        return null;
    }
}
