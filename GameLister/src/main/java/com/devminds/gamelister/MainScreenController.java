package com.devminds.gamelister;

import com.devminds.gamelister.dbacces.dao.DAOGame;
import com.devminds.gamelister.dbacces.dao.DaoMainScreenTable;
import com.devminds.gamelister.objects.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainScreenController {
    @FXML private Label textoBemVindo;
    @FXML private TableView<Game> tbl_games;
    @FXML private TableColumn<Game,String> col1;
    @FXML private TableColumn<Game,String> col2;
    @FXML private TableColumn<Game,String> col3;
    @FXML private TableColumn<Game,String> col4;
    @FXML private TableColumn<Game,Integer> col5;
    @FXML private TableColumn<Game,String> col6;
    @FXML private Button btn_registrar;

    ObservableList<Game> listObj = FXCollections.observableArrayList();


    @FXML
    public void changeNome(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNome(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeGenero(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setGenero(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeCritica(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setCritica(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeAno(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setAno(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changetamanho(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTamanho(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changePirata(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTamanho(edittedCell.getNewValue().toString());
    }

    private void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        DaoMainScreenTable dao = new DaoMainScreenTable();
        DAOGame daogame = new DAOGame();
        int aux = dao.getSemestre().size();
        for (int i = 0; i < aux; i++) {
            daogame.updateGame(tbl_games.getItems().get(i).getNome(),tbl_games.getItems().get(i).getGenero(),tbl_games.getItems().get(i).getCritica(),tbl_games.getItems().get(i).getAno(),tbl_games.getItems().get(i).getTamanho(),tbl_games.getItems().get(i).getPirata(),tbl_games.getItems().get(i).getIdgame());
        }

    }



    public void setTableItems(ObservableList<Game> list){
        tbl_games.setItems(list);
    }
    @FXML private void stageTelaRegistrar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela_registrar.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("REGISTRAR");
        stage.setScene(new Scene(root1));
        stage.show();
    }


    @FXML private void initialize(){
        DaoMainScreenTable dao = new DaoMainScreenTable();
        ObservableList<Game> obsList = FXCollections.observableArrayList();
        obsList = dao.getSemestre();
        col1.setCellValueFactory(new PropertyValueFactory<Game, String>("nome"));
        col2.setCellValueFactory(new PropertyValueFactory<Game, String>("genero"));
        col3.setCellValueFactory(new PropertyValueFactory<Game, String>("critica"));
        col4.setCellValueFactory(new PropertyValueFactory<Game, String>("ano"));
        col5.setCellValueFactory(new PropertyValueFactory<Game, Integer>("pirata"));
        col6.setCellValueFactory(new PropertyValueFactory<Game, String>("tamanho"));
        tbl_games.setEditable(true);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());
        col5.setCellFactory(TextFieldTableCell.forTableColumn());
        col6.setCellFactory(TextFieldTableCell.forTableColumn());


        setTableItems(obsList);
    }
}