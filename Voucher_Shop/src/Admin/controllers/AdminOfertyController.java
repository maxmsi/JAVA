package Admin.controllers;

import Application.models.Offer;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Collection;

public class AdminOfertyController {

    @FXML
    public Button dodajOferteButton, usunOferteButton;
    @FXML
    public TextField nazwa, firma, cena;
    @FXML
    public TableView<Offer> tableOferty;
    @FXML
    private TableColumn<Offer, Integer> kolumnaId;
    @FXML
    private TableColumn<Offer, String> kolumnaNazwa;
    @FXML
    private TableColumn<Offer, String> kolumnaFirma;
    @FXML
    private TableColumn<Offer, Integer> kolumnaCena;

    private Offer o = new Offer();

    public ObservableList<Offer> data = FXCollections.observableArrayList(o.selectOffers());

    ObservableList<Offer> offerList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        Offer defOffer = new Offer();
        offerList.addAll(defOffer.selectOffers());
        tableOferty.setItems(offerList);

        kolumnaId.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("id"));
        kolumnaNazwa.setCellValueFactory(new PropertyValueFactory<Offer, String>("name"));
        kolumnaFirma.setCellValueFactory(new PropertyValueFactory<Offer, String>("company"));
        kolumnaCena.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("price"));

        ReadOnlyIntegerProperty selectedIndex = tableOferty.getSelectionModel().selectedIndexProperty();

    }


    public void dodajOferta(ActionEvent actionEvent) {
        if (!isStringInt(cena.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Prosze podac prawidlowa cene");
            alert.showAndWait();
            return;
        }
        try {
            Offer oferta = new  Offer();
            oferta.insertOffer(nazwa.getText(),firma.getText(),Integer.parseInt(cena.getText()));
            offerList.clear();
            Offer defOffer = new Offer();
            offerList.addAll(defOffer.selectOffers());
            tableOferty.setItems(offerList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Poprawnie wstawiono do bazy");
            alert.showAndWait();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Blad  przy wstawianiu do bazy");
            alert.showAndWait();
            return;
        }

    }

    public void usunOferta(ActionEvent actionEvent) {
        try {
            tableOferty.getSelectionModel().getSelectedItem().deleteOffer(o.getId());
            tableOferty.getItems().removeAll(tableOferty.getSelectionModel().getSelectedItem());
            offerList.clear();
            Offer defOffer = new Offer();
            offerList.addAll(defOffer.selectOffers());
            tableOferty.setItems(offerList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Poprawnie usunieto z bazy");
            alert.showAndWait();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Blad przy usuwaniu z bazy");
            alert.showAndWait();
            return;
        }

    }

    private void setColumn() {
        kolumnaId.setCellValueFactory(
                new PropertyValueFactory<Offer, Integer>("id"));
        kolumnaNazwa.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("name"));
        kolumnaFirma.setCellValueFactory(
                new PropertyValueFactory<Offer, String>("company"));
        kolumnaCena.setCellValueFactory(
                new PropertyValueFactory<Offer, Integer>("price"));
    }

    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

}
