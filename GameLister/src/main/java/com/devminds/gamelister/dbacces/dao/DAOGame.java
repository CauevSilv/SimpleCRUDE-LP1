package com.devminds.gamelister.dbacces.dao;

import com.devminds.gamelister.dbacces.SQLConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOGame {
    public void registerGame(String nome, String genero, String critica, String ano, String tamanho, Integer isPirata) {
        try (Connection con = SQLConn.getConnection()) {
            String sql_update = "insert into game(nome,genero,critica,ano,tamanho,pirata) values (?,?,?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, nome);
            pst.setString(2,genero);
            pst.setString(3, critica);
            pst.setString(4, ano);
            pst.setString(5, tamanho);
            pst.setInt(6, isPirata);
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar jogo!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateGame(String nome, String genero, String critica, String ano, String tamanho, Integer isPirata, Integer idgame) throws SQLException, ClassNotFoundException {
        try (Connection con = SQLConn.getConnection()){
            String sql_update = "UPDATE game SET nome = ?, genero = ?, critica = ? , ano = ?, tamanho = ? , pirata = ? where id_game = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, nome);
            pst.setString(2,genero);
            pst.setString(3, critica);
            pst.setString(4, ano);
            pst.setString(5,tamanho);
            pst.setInt(6, isPirata);
            pst.setInt(7, idgame);

            pst.executeUpdate();
        }
    }



}
