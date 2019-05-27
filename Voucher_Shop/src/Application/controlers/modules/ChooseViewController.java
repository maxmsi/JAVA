package Application.controlers.modules;

import Application.controlers.interfaces.IChooseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseViewController extends BaseController implements IChooseViewController {

    @FXML
    public Button ListOfOffersBtn;
    @FXML
    public Button BuyVoucherBtn;
    @FXML
    public Button AddNewOffersBtn;
    @FXML
    public Button LogoutBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void OnLogoutBtnClicked(MouseEvent mouseEvent) throws IOException {
        GoToAuthorization();
    }

    @Override
    public void OnAddNewOffersBtnClicked(MouseEvent mouseEvent) throws IOException {
        GoToAddOffer();
    }

    @Override
    public void OnBuyVoucherBtnClicked(MouseEvent mouseEvent) throws IOException {
        GoToBuyVoucher();
    }

    @Override
    public void OnListOfOffersButtonClicked(MouseEvent mouseEvent) throws IOException {
        GoToSearchOffer();
    }
}
