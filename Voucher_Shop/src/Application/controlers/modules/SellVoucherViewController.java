package Application.controlers.modules;

import Application.controlers.interfaces.ISellVoucherController;
import Application.models.Offer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class SellVoucherViewController extends Application.controlers.modules.BaseController implements ISellVoucherController {
    @FXML
    public Button SellVoucherBtn;
    @FXML
    public TextField VoucherName, Company, Price;

    public void OnSellVoucherBtnClicked(MouseEvent mouseEvent) {
        if (VoucherName.getText().isEmpty() || Company.getText().isEmpty() || Price.getText().isEmpty()){
        	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Prosze wypelnic wszystkie pola");
        	 alert.showAndWait(); 
        }
   	 	else {
	        if (isStringInt(Price.getText()) == false) {
   	        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
   	        		alert.setHeaderText("Prosze podac prawidlowa cene");
   	        		alert.showAndWait();
   	        		return;		
   	        }
   	        try {
   	        	Offer oferta = new  Offer();
   	        	oferta.insertOffer(VoucherName.getText(),Company.getText(),Integer.parseInt(Price.getText()));
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        		alert.setHeaderText("Poprawnie wstawiono do bazy");
        		alert.showAndWait();
        		return;
   	        } catch (Exception e) {
   	        	e.printStackTrace();
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        		alert.setHeaderText("Blad przy wstawianiu do bazy");
        		alert.showAndWait();
        		return;
   	        }
       	 }
   	 } 
    
    public void OnReturnBtnClicked(MouseEvent mouseEvent) {
    	try {
    		GoToChooseView();
    	} catch (Exception e) {
	        	e.printStackTrace();
	        	return;
	   }
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