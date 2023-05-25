package tests;

import models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("marym@gmail.com").withPassword("Mm12345@"));
        }
        app.getHelperContact().provideContacts(); /// if list <3 ===> add 3 contacts
    }

    @Test(groups = {"smoke"})
    public void removeFirstContact() {
        // Assert size list less when one
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);

    }

    @Test
    public void removeAllContacts() {
        app.getHelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(), "No Contacts here!");
        // "No contacts Here"
    }
}