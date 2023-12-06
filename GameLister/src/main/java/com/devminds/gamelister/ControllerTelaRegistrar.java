package com.devminds.gamelister;
;
import com.devminds.gamelister.dbacces.dao.DAOGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
        DAOGame dao = new DAOGame();
        dao.registerGame(nome.getText(),genero.getText(),critica.getText(),ano.getText(),tamanho.getText(),ispirata.getSelectionModel().getSelectedItem());
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
