package Admin.controllers;

import Application.controlers.Helpers.ViewTypes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseControllerAdmin {

    @FXML
    protected AnchorPane MainPane;

    @FXML
    public void initialize() {
    }

    @FXML
    public void GoToOferty() throws IOException{
        GoToView("../views/AdminOfertyView.fxml");
    }

    @FXML
    public void GoToUzytkownicy() throws IOException{
        GoToView("../views/AdminUzytkownicyView.fxml");
    }

    private void GoToView(String viewType) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource(viewType));
        MainPane.getChildren().setAll( pane );
    }
}
