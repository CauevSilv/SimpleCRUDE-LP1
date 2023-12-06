package com.devminds.gamelister.dbacces.dao;

import com.devminds.gamelister.dbacces.SQLConn;
import com.devminds.gamelister.objects.Game;
import com.devminds.gamelister.objects.RSConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DaoMainScreenTable {
    public ObservableList<Game> getSemestre(){
        ObservableList<Game> lista = FXCollections.observableArrayList();
        try(Connection con = SQLConn.getConnection()) {
            String sql_insert = "SELECT * from game";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            ResultSet rs = pst.executeQuery();
            lista = RSConverter.converterGameRS(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;

    }
}
