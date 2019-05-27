package Application.UnitTests;

import Application.Run.Main;
import Application.controlers.modules.SellVoucherViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class SellVoucherTest extends ApplicationTest {

    private SellVoucherViewController controller;

    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../views/SellVoucherView.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

    }

    @Test
    public void ControllerCreatedTest () {
        Assert.assertNotNull(controller);
    }

    @Test
    public void CreateVoucherWithInvalidPriceTest () {
        controller.VoucherName.setText("VoucherName");
        controller.Company.setText("Firma");
        controller.Price.setText("asd");
        Assert.assertFalse(controller.isStringInt(controller.Price.getText()));
    }

}
