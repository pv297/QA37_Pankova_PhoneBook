package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com","P29348092l@");
        app.getHelperUser().submitLogin();
        // time -----> singOut

        // Assert

       // Assert.assertEquals();
       // Assert.assertNotEquals();
        //Assert.assertTrue();
       // Assert.assertFalse();

      Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("p.v.2977187@gmail.com","P29348092l@");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }


}
