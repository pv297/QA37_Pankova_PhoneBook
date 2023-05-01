package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Tom")
                .lastName("Tomson")
                .phone("3456780101")
                .email("tomtom@gmail.com")
                .address("Haifa")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Tomy")
                .lastName("Tomsons")
                .phone("345678701010")
                .email("tomtoms@gmail.com")
                .address("Holon")
                .description("friend")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()  // build from rules lombok, without new
                .name("Tom")
                .lastName("Tomson")
                .phone("345")
                .email("tomtom@gmail.com")
                .address("Haifa")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Tomy")
                .lastName("Tomsons")
                .phone("3456787111111111111111111")
                .email("tomtoms@gmail.com")
                .address("Holon")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Tomy")
                .lastName("Tomsons")
                .phone("wwwwwwwwwwwwwwwwwww")
                .email("tomtoms@gmail.com")
                .address("Holon")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Tomy")
                .lastName("Tomsons")
                .phone("")
                .email("tomtoms@gmail.com")
                .address("Holon")
                .description("friend")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
