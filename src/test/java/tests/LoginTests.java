package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com", "P29348092l@");
        app.getHelperUser().submitLogin();
        // time -----> singOut
        // Assert.assertEquals();
        // Assert.assertNotEquals();
        //Assert.assertTrue();
        // Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Asser check is element button 'Sing out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com", "P29348092l@");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Asser check is element button 'Sing out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187", "P29348092l@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Asser check is alert present ");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com", "P29348092l");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data ----> email: p.v@gmail.com' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v@gmail.com", "P29348092l@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
}
