package Admin.controllers;

import Application.models.Offer;
import Application.models.User;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class AdminUzytkownicyController {

    @FXML
    public TableView<User> tableUzytkownicy;
    @FXML
    public Button usunUzytkownikaButton;
    @FXML
    public Button dodajUzytkownikaButton;
    @FXML
    public TextField imie, nazwisko, pesel, status, haslo;
    @FXML
    private TableColumn<Offer, Integer> cId;
    @FXML
    private TableColumn<Offer, String> cImie;
    @FXML
    private TableColumn<Offer, String> cNazwisko;
    @FXML
    private TableColumn<Offer, String> cPesel;
    @FXML
    private TableColumn<Offer, String> cStatus;
    @FXML
    private TableColumn<Offer, String> cHaslo;

    private User u = new User();

    public ObservableList<User> data = FXCollections.observableArrayList(u.selectUserss());
    public ObservableList<User> offerList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        User defOffer = new User();
        offerList.addAll(defOffer.selectUserss());
        tableUzytkownicy.setItems(offerList);

        cId.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("id"));
        cImie.setCellValueFactory(new PropertyValueFactory<Offer, String>("name"));
        cNazwisko.setCellValueFactory(new PropertyValueFactory<Offer, String>("surname"));
        cPesel.setCellValueFactory(new PropertyValueFactory<Offer, String>("pesel"));
        cStatus.setCellValueFactory(new PropertyValueFactory<Offer, String>("status"));
        cHaslo.setCellValueFactory(new PropertyValueFactory<Offer, String>("password"));

        ReadOnlyIntegerProperty selectedIndex = tableUzytkownicy.getSelectionModel().selectedIndexProperty();

    }


    public void dodajUzytkownika(ActionEvent actionEvent) {
        try {
            User user = new User();
            user.insertUser(imie.getText(),nazwisko.getText(),pesel.getText(),status.getText(),haslo.getText());
            offerList.clear();
            User defOffer = new User();
            offerList.addAll(defOffer.selectUserss());
            tableUzytkownicy.setItems(offerList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Poprawnie wstawiono do bazy");
            alert.showAndWait();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Blad   przy wstawianiu do bazy");
            alert.showAndWait();
            return;
        }

    }

    public void usunUzytkownika(ActionEvent actionEvent) {
        try {
            tableUzytkownicy.getSelectionModel().getSelectedItem().deleteUser(u.getId());
            tableUzytkownicy.getItems().removeAll(tableUzytkownicy.getSelectionModel().getSelectedItem());
            offerList.clear();
            User defOffer = new User();
            offerList.addAll(defOffer.selectUserss());
            tableUzytkownicy.setItems(offerList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Poprawnie usuniety uzytkownik z bazy");
            alert.showAndWait();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Blad przy usuwaniu uzytkownika z bazy");
            alert.showAndWait();
            return;
        }
    }

    private void setColumn() {
        cId.setCellValueFactory(
                new PropertyValueFactory<Offer, Integer>("id"));
        cImie.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("name"));
        cNazwisko.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("company"));
        cPesel.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("pesel"));
        cStatus.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("status"));
        cHaslo.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("password"));
    }


}
 