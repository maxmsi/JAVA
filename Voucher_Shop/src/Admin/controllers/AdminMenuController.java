package Admin.controllers;

import Admin.interfaces.IAdminMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class AdminMenuController extends BaseControllerAdmin {

    @FXML
    private Button buttonOferty;
    @FXML
    private Button buttonUzytkownicy;
    @FXML
    protected AnchorPane MainPane;
    @FXML
    public void initialize(){
    }

    public AdminMenuController(){
    }


    public void openOferty (ActionEvent actionEvent) throws IOException {
            GoToOferty();

    }

    public void openUzytkownicy(ActionEvent actionEvent) throws IOException {
            GoToUzytkownicy();

    }
}
