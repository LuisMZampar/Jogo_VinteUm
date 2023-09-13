package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JogoDAO {

    final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final static String USER = "rm550531";
    final static String PASS = "300704";

    public static void inserir(Jogo jogo) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var sql = "INSERT INTO jogo(resultado) VALUES(?)";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, jogo.resultado());

        comando.executeUpdate();

        conexao.close();

    }
}