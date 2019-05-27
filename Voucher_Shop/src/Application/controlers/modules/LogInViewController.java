package Application.controlers.modules;

import Application.controlers.interfaces.ILogInController;
import Application.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class LogInViewController extends BaseController implements ILogInController {
    @FXML
    public Button LogInBtn;
    @FXML
    public TextField Username, Password;
   	public String status = null;
   	public int id = 0;
    public void OnLogInBtnClicked(MouseEvent mouseEvent) {
        if (Username.getText().isEmpty() || Password.getText().isEmpty()){
        	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Prosze wypelnic wszystkie pola");
        	 alert.showAndWait();
        }
        if (isStringInt(Username.getText()) == false) {
       		Alert alert = new Alert(Alert.AlertType.INFORMATION);
       		alert.setHeaderText("Prosze podac prawidlowy identyfikator uzytkownika");
       		alert.showAndWait();
       		return;		
       }
   	 	else {
   	        try {
   	        	List<User> Users = new LinkedList<User>();
   	        	User uzytkownicy = new User();
   	        	Users = uzytkownicy.selectUserss();

   	        	for (User uzytkownik : Users) {
   	        	    if (uzytkownik.getId() == Integer.parseInt(Username.getText()) && uzytkownik.getPassword().equals(Password.getText()))
   	        	    {
   	        	    	status = uzytkownik.getStatus();
   	        	    	id = uzytkownik.getId();
						GoToChooseView();
   	 	        		return;
   	        	    }
   	        	}
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        		alert.setHeaderText("nie ma takiego uzytkownika");
        		alert.showAndWait();
        		return;
   	        } catch (Exception e) {
   	            e.printStackTrace();
   	            return;
   	        }
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



