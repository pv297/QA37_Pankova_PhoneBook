package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContactTests extends TestBase {
    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().withEmail("p.v.2977187@gmail.com").withPassword("P29348092l@"));
    }

    @Test
    public void addNewContactSuccessAll() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("345678" + i)
                .email("tomtom" + i + "@gmail.com")
                .address("Holon,Sokolov,122-2")
                .description("friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().SaveContact();
        Assert.assertTrue(app.getHelperContact().isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke")));
        Assert.assertTrue(app.getHelperContact().isElementPresent(By.xpath("//a[@href='/contacts' and @class='active']")));

    }

    @Test
    public void addNewContactSuccess() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("345678" + i)
                .email("tomtom" + i + "@gmail.com")
                .address("Holon,Sokolov,122-2")
                .description("")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().SaveContact();
        Assert.assertTrue(app.getHelperContact().isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke")));
        Assert.assertTrue(app.getHelperContact().isElementPresent(By.xpath("//a[@href='/contacts' and @class='active']")));

    }
}
