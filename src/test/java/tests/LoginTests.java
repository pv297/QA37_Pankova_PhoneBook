package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass  = DataProviderUser.class)
    public void loginSuccess(String email,String password) {
        logger.info("Start test with name 'loginSuccess'");
        //logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l@'");
        logger.info("Test data ----> email: " + email + " & password : " + password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        // time -----> singOut
        // Assert.assertEquals();
        // Assert.assertNotEquals();
        //Assert.assertTrue();
        // Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Asser check is element button 'Sing out' present");
    }


    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data ----> " + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Asser check is element button 'Sing out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ----> email: p.v.2977187' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187", "P29348092l@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data ----> email: p.v.2977187@gmail.com' & password : 'P29348092l'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com", "P29348092l");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data ----> email: p.v@gmail.com' & password : 'P29348092l@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v@gmail.com", "P29348092l@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
}
