package Application.controlers.modules;

import Application.controlers.interfaces.IBuyVoucherController;
import Application.models.Offer;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BuyVoucherViewController extends BaseController implements IBuyVoucherController {
    @FXML
    public Button BuyVoucherBtn;
    @FXML
    public TableView<Offer> MainTable;

    @FXML
    public TableColumn<Offer, Integer> idCol;
    @FXML
    public TableColumn<Offer, String> nameCol;
    @FXML
    public TableColumn<Offer, String> compCol;
    @FXML
    public TableColumn<Offer, String> DateCol;
    @FXML
    public TableColumn<Offer, Integer> priceCol;

    ObservableList<Offer> offerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BuyVoucherBtn.setDisable(true);

        Offer defOffer = new Offer();
        offerList.addAll(defOffer.selectOffers());
        MainTable.setItems(offerList);

        idCol.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Offer, String>("name"));
        compCol.setCellValueFactory(new PropertyValueFactory<Offer, String>("company"));
        DateCol.setCellValueFactory(new PropertyValueFactory<Offer, String>("event_date"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("price"));

        ReadOnlyIntegerProperty selectedIndex = MainTable.getSelectionModel().selectedIndexProperty();

        BuyVoucherBtn.disableProperty().bind(selectedIndex.lessThanOrEqualTo(0));
    }

    public void OnBuyVoucherBtnClicked(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potwierdzenie zakupu");
        alert.setHeaderText("Czy na pewno chcesz kupic ten voucher?\n");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            int index = MainTable.getSelectionModel().getSelectedIndex();

            Offer offer = MainTable.getItems().get(index);
            offer.deleteOffer(offer.getId());
            GoToAuthorization();

        } else {
        }
    }

    private void FillTable(){


    }
}
