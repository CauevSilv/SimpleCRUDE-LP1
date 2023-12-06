package com.devminds.gamelister.objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RSConverter {
    public static ObservableList<Game> converterGameRS(ResultSet resultSet){
        ObservableList<Game> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                Game obj = new Game();
                obj.setNome(resultSet.getString("nome"));
                obj.setGenero(resultSet.getString("genero"));
                obj.setCritica(resultSet.getString("critica"));
                obj.setAno(resultSet.getString("ano"));
                obj.setPirata(resultSet.getInt("pirata"));
                obj.setIdgame(resultSet.getInt("id_game"));

                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
}
