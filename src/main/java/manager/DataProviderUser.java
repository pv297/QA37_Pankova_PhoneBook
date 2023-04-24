package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"p.v.2977187@gmail.com","P29348092l@"});
        list.add(new Object[]{"marym@gmail.com","Mm12345@"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("p.v.2977187@gmail.com").withPassword("P29348092l@")});
        list.add(new Object[]{new User().withEmail("marym@gmail.com").withPassword("Mm12345@")});

        return list.iterator();
    }
}
