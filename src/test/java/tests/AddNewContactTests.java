package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
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

    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAllFields(Contact contact) {

        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue((app.getHelperContact().isContactAddedByName(contact.getName())));
        Assert.assertTrue((app.getHelperContact().isContactAddedByPhone(contact.getPhone())));
    }
    @Test(dataProvider = "contactCSV",dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAllFieldsCSV(Contact contact) {

        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue((app.getHelperContact().isContactAddedByName(contact.getName())));
        Assert.assertTrue((app.getHelperContact().isContactAddedByPhone(contact.getPhone())));
    }
    @Test
    public void addNewContactSuccessRequiredFields() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Tom" + i)
                .lastName("Tomson")
                .phone("345678" + i)
                .email("tomtom" + i + "@gmail.com")
                .address("Holon")
                .description("")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
//      Assert.assertTrue(app.getHelperContact().isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke")));
//      Assert.assertTrue(app.getHelperContact().isElementPresent(By.xpath("//a[@href='/contacts' and @class='active']")));
        Assert.assertTrue((app.getHelperContact().isContactAddedByName(contact.getName())));
        Assert.assertTrue((app.getHelperContact().isContactAddedByPhone(contact.getPhone())));
    }

    @Test
    public void addNewContactWrongName() {

        Contact contact = Contact.builder()
                .name("")  // or null
                .lastName("Tomson")
                .phone("3456789012")
                .email("tomtom@gmail.com")
                .address("Holon")
                .description("empty name")
                .build();

        logger.info("Tests run with data: --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongAddress() {

        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("3456789012")
                .email("tomtom@gmail.com")
                .address("")
                .description("empty address")
                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());


    }

    @Test
    public void addNewContactWrongLastName() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("")
                .phone("3456789012")
                .email("tomtom@gmail.com")
                .address("TA")
                .description("empty last name")
                .build();

        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test (dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact) {

//        Contact contact = Contact.builder()
//                .name("Tim")
//                .lastName("Timson")
//                .phone("")
//                .email("timtom@gmail.com")
//                .address("Holon")
//                .description("empty phone")
//                .build();

        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail() {

        Contact contact = Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("34567890123")
                .email("tomtomgmail.com")  /// bug if field is empty
                .address("Holon")
                .description("wrong email")
                .build();

        logger.info("Tests run with data: --->"+contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue((app.getHelperContact().isAlertPresent("Email not valid: must be a well-formed email address")));
    }
}
