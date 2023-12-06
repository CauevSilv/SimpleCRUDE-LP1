package com.devminds.gamelister;
;
import com.devminds.gamelister.dbacces.dao.DAOGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;


public class ControllerTelaRegistrar {
    @FXML private TextField nome;
    @FXML private TextField genero;
    @FXML private TextField critica;
    @FXML private TextField ano;
    @FXML private TextField tamanho;
    @FXML private ChoiceBox<Integer> ispirata;

    @FXML private Button btn_voltar;
    @FXML private Button btn_salvar;

    @FXML private void salvarNoBD (ActionEvent event){
        try{
            DAOGame dao = new DAOGame();
            dao.registerGame(nome.getText(),genero.getText(),critica.getText(),ano.getText(),tamanho.getText(),ispirata.getSelectionModel().getSelectedItem());
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro!");
            alert.setHeaderText("Todos os campos são de preenchimento OBRIGATÓRIO.");
            alert.showAndWait();
        }

    }


    @FXML private void stageVoltar(ActionEvent event){
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }

    @FXML private void initialize(){
        ObservableList<Integer> caixa = FXCollections.observableArrayList();
        caixa.add(0);
        caixa.add(1);
        ispirata.setItems(caixa);


    }
}
