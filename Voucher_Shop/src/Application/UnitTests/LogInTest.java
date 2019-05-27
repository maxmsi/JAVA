package Application.UnitTests;

import Application.Run.Main;
import Application.controlers.modules.LogInViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class LogInTest extends ApplicationTest {

    private LogInViewController controller;

    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../views/LogInView.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
    }

    @Test
    public void ControllerCreatedTest () {
        Assert.assertNotNull(controller);
    }

}