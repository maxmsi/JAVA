package Application.UnitTests;
import Application.models.User;
import Application.models.Offer;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ModelsTest {


        public static final String EXPECTED_FIRST_NAME = "Kamil";
        public static final String EXPECTED_LAST_NAME = "Jakis";
        public static final String EXPECTED_STATE = "User";
        public static final int EXPECTED_ID = 500;
        public static final String EXPECTED_PASSWORD = "Haslo";
        public static final String EXPECTED_PESEL = "9707070202028";

        public static final int EXPECTED_IDOFFER=600;
        public static final String EXPECTED_NAME="test";
        public static final String EXPECTED_COMPANY="firma";
        public static final int EXPECTED_PRICE =1002;

        User  user = new User(500,"User", "Haslo","Kamil", "Jakis","9707070202028");
        Offer offer= new Offer (600, "test", "firma", 1002);


        @After
        public void tearDown() throws Exception {
            System.out.println("Test Completed");

        }

        @Test
        public void testUserDetails() throws Exception {
            Assert.assertEquals(EXPECTED_FIRST_NAME, user.getName());
            Assert.assertEquals(EXPECTED_LAST_NAME, user.getSurname());
            Assert.assertEquals(EXPECTED_STATE, user.getStatus());
            Assert.assertEquals(EXPECTED_ID,user.getId());
            Assert.assertEquals(EXPECTED_PASSWORD,user.getPassword());
            Assert.assertEquals(EXPECTED_PESEL,user.getPesel());





        }

        @Test
        public void testOfferDetails() throws Exception {
        Assert.assertEquals(EXPECTED_IDOFFER, offer.getId());
        Assert.assertEquals(EXPECTED_NAME, offer.getName());
        Assert.assertEquals(EXPECTED_COMPANY, offer.getCompany());
        Assert.assertEquals(EXPECTED_PRICE,offer.getPrice());






    }
    }


