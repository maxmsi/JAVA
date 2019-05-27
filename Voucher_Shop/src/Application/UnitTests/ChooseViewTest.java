package Application.UnitTests;

import Application.Run.Main;
import Application.controlers.modules.ChooseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class ChooseViewTest extends ApplicationTest {

    private ChooseViewController controller;

    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../views/ChooseView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
        controller = loader.getController();
    }

    @Test
    public void ControllerCreatedTest () {
        Assert.assertNotNull(controller);
    }

}