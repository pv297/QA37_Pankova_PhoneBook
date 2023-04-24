package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();

        list.add (new Object[]{Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("3456780101")
                .email("tomtom@gmail.com")
                .address("Haifa")
                .description("friend")
                .build()});

        list.add (new Object[]{Contact.builder()
                .name("Tomy")
                .lastName("Tomsons")
                .phone("345678701010")
                .email("tomtoms@gmail.com")
                .address("Holon")
                .description("friend")
                .build()});

        return list.iterator();
    }
}
