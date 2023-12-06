package com.devminds.gamelister;

import com.devminds.gamelister.dbacces.dao.DAOGame;
import com.devminds.gamelister.dbacces.dao.DaoMainScreenTable;
import com.devminds.gamelister.objects.Game;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML private TableColumn<Game,String> col5;
    @FXML private TableColumn<Game,String> col6;
    @FXML private TableColumn<Game,Game> col7;
    @FXML private Button btn_registrar;

    ObservableList<Game> listObj = FXCollections.observableArrayList();
    Game gameEditado;


    @FXML
    public void changeNome(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNome(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }

    @FXML
    public void changeGenero(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setGenero(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }
    @FXML
    public void changeCritica(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setCritica(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }
    @FXML
    public void changeAno(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setAno(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }
    @FXML
    public void changetamanho(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTamanho(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }
    @FXML
    public void changePirata(TableColumn.CellEditEvent edittedCell) {
        Game trabalhoSelecionado = tbl_games.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTamanho(edittedCell.getNewValue().toString());
        gameEditado = trabalhoSelecionado;
    }
    @FXML
    private void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        DaoMainScreenTable dao = new DaoMainScreenTable();
        DAOGame daogame = new DAOGame();
        int aux = dao.getSemestre().size();
        if (tbl_games.getItems().isEmpty()){
            setTableItems(dao.getSemestre());
        } else {
            if (aux != tbl_games.getItems().size()) {
                if (gameEditado == null) {
                    setTableItems(dao.getSemestre());
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText("A lista estava desatualizada, por isso atualizamos ela para você : ).\nDeseja salvar suas mudanças mesmo assim?");
                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        daogame.updateGame(gameEditado);
                        setTableItems(dao.getSemestre());
                        gameEditado = null;
                    } else if (alert.getResult() == ButtonType.NO) {
                        setTableItems(dao.getSemestre());
                        gameEditado = null;
                    }
                }
            } else {
                if (gameEditado != null){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText("A lista estava desatualizada, por isso atualizamos ela para você : ).\nDeseja salvar suas mudanças mesmo assim?");
                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        daogame.updateGame(gameEditado);
                        setTableItems(dao.getSemestre());
                        gameEditado = null;
                    } else if (alert.getResult() == ButtonType.NO) {
                        setTableItems(dao.getSemestre());
                        gameEditado = null;
                    }
                }
            }
        }


    }

    @FXML
    private void deletar(ActionEvent event, Game item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deletar???");
        alert.setHeaderText("Deseja deletar o jogo selecionado? Isso NÃO tem volta. Não adianta chorar.");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            DAOGame daoGame = new DAOGame();
            DaoMainScreenTable daoNobvo = new DaoMainScreenTable();
            daoGame.deleteGame(item);
            tbl_games.setItems(daoNobvo.getSemestre());
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
        col5.setCellValueFactory(new PropertyValueFactory<Game, String>("pirata"));
        col6.setCellValueFactory(new PropertyValueFactory<Game, String>("tamanho"));
        col7.setCellFactory(param -> new TableCell<Game, Game>() {
            private final Button button = new Button("Deletar");

            @Override
            protected void updateItem(Game item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        deletar(event,item);
                    });
                }
            }
        });
        col7.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
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