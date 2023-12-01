package com.devminds.gamelister;

import com.devminds.gamelister.objects.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML private Label textoBemVindo;
    @FXML private TableView<Game> tbl_games;
    @FXML private TableColumn<Game,String> col1;
    @FXML private TableColumn<Game,String> col2;
    @FXML private TableColumn<Game,String> col3;
    @FXML private TableColumn<Game,String> col4;
    @FXML private TableColumn<Game,String> col5;
    @FXML private TableColumn<Game,String> col6;
    @FXML private TableColumn<Game,Boolean> col7;

    ObservableList<Game> listObj = FXCollections.observableArrayList();

    public void setTableItems(ObservableList<Game> list){
        tbl_games.setItems(list);
    }


    @FXML private void initialize(){
        col1.setCellValueFactory(new PropertyValueFactory<Game, String>("nomeAluno"));
        col2.setCellValueFactory(new PropertyValueFactory<Game, String>("tipo"));
        col3.setCellValueFactory(new PropertyValueFactory<Game, Double>("nota1"));
        col4.setCellValueFactory(new PropertyValueFactory<Game, Double>("nota2"));
        col5.setCellValueFactory(new PropertyValueFactory<Game, Double>("nota3"));
        col6.setCellValueFactory(new PropertyValueFactory<Game, Double>("nota4"));
        col7.setCellValueFactory(new PropertyValueFactory<Game, Double>("nota5"));


        setTableItems(listObj);
    }
}