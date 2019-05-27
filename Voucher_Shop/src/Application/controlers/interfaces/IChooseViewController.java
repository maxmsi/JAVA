package Application.controlers.interfaces;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public interface IChooseViewController extends IBaseController{
    void OnLogoutBtnClicked(MouseEvent mouseEvent) throws IOException;
    void OnAddNewOffersBtnClicked(MouseEvent mouseEvent) throws IOException;
    void OnBuyVoucherBtnClicked(MouseEvent mouseEvent) throws IOException;
    void OnListOfOffersButtonClicked(MouseEvent mouseEvent) throws IOException;
}
