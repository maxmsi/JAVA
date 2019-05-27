package Application.controlers.modules;

import Application.controlers.Helpers.ViewTypes;
import Application.controlers.interfaces.IBaseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseController implements IBaseController {

    @FXML
    protected AnchorPane MainPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void GoToAddOffer() throws IOException{
        GoToView( ViewTypes.AddOffer );
    }

    @FXML
    public void GoToAuthorization() throws IOException {
        GoToView( ViewTypes.LogIn );
    }

    @FXML
    public void GoToBuyVoucher() throws IOException{
        GoToView( ViewTypes.BuyVoucher);
    }

    @FXML
    public void GoToChooseView() throws IOException{
        GoToView(ViewTypes.ChooseView);
    }

    @FXML
    public void GoToSearchOffer() throws IOException{
        GoToView(ViewTypes.SearchOffer);
    }

    @FXML
    public void Error(String message) throws IOException {
        Alert alert = new Alert( Alert.AlertType.ERROR);
        alert.setTitle("Błąd!");
        alert.setContentText(message);
        alert.showAndWait();
        GoToAuthorization();
    }

    @FXML
    public void Error() throws IOException {
        Alert alert = new Alert( Alert.AlertType.ERROR);
        alert.setTitle("Błąd!");
        alert.setContentText("Wystąpił błąd, zostaniesz przeniesiony do menu");
        alert.showAndWait();
        GoToAuthorization();
    }

    @FXML
    public void Success(String message) throws IOException {
        Alert alert = new Alert( Alert.AlertType.ERROR);
        alert.setTitle("Sukces");
        alert.setContentText(message);
        alert.showAndWait();
        GoToAuthorization();
    }

    @FXML
    public void Success() throws IOException {
        Alert alert = new Alert( Alert.AlertType.ERROR);
        alert.setTitle("Sukces");
        alert.setContentText("Udało się wykonać akcję, zostaniesz przeniesiony do menu");
        alert.showAndWait();
        GoToAuthorization();
    }

    //region Private Methods
    private void GoToView(String viewType) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource(viewType));
        MainPane.getChildren().setAll( pane );
    }
}
