package Application.controlers.modules;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import Application.controlers.interfaces.ISearchController;
import Application.models.Offer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SearchOfferViewController extends BaseController implements ISearchController {
		
		private String voucher;
		@FXML
	    private TextField textField;

	    @FXML
	    private Button btn;

	    @FXML
	    private Label titleLabel;

	    @FXML
	    private Label voucherLabel;
	    
	    @FXML
	    private Button ReturnBtn;
	    @FXML
	    private TableView<Offer> tableView;

	    @FXML
	    private TableColumn<Offer, Integer> cId;

	    @FXML
	    private TableColumn<Offer, String> cNazwa;
	    
	    @FXML
	    private TableColumn<Offer, String> cFirma;
	    
	    @FXML
	    private TableColumn<Offer, Integer> cCena;

	    private Offer o = new Offer();
	    
	    private ObservableList<Offer> list =
	            FXCollections.observableArrayList(o.selectOffers());
	    
	    private ObservableList<Offer> tlist ;	            
	   
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			setColumn();
			tableView.setItems(list);
		}
		
		public void OnReturnBtnClicked(MouseEvent mouseEvent) {
	    	try {
	    		GoToChooseView();
	    	} catch (Exception e) {
		        	e.printStackTrace();
		        	return;
		   }
	    }
		
		public void OnBtnClicked(MouseEvent mouseEvent) {
		        List<Offer> temp = new LinkedList<Offer>();
		        comparingName(temp);
		   		tlist = FXCollections.observableArrayList(temp);
		   		setColumn();
				tableView.setItems(tlist);        
		}
		
		private void comparingName(List<Offer> temp) {
			voucher=textField.getText();
	    	textField.clear();
			for (Offer o : list) {
			 if(o.getName().equals(voucher)) {
				 temp.add(o);
			 }
			}
		}
		
		private void setColumn() {
			cId.setCellValueFactory(
			        new PropertyValueFactory<Offer, Integer>("id"));
			cNazwa.setCellValueFactory(
					new PropertyValueFactory<Offer, String>("name"));
			cFirma.setCellValueFactory(
					new PropertyValueFactory<Offer, String>("company"));
			cCena.setCellValueFactory(
					new PropertyValueFactory<Offer, Integer>("price"));
		}
}
