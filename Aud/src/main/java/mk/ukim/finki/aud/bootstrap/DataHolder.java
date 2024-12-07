package mk.ukim.finki.aud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.aud.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {

    public static List<Category> categories=new ArrayList<>();
    public static List<User> users=new ArrayList<>();
    public static List<Manufacturer> manufacturers=new ArrayList<>();
    public static List<Product> products=new ArrayList<>();
    public static List<ShopingCart> shopingCarts=new ArrayList<>();



//    @PostConstruct
//    public void init(){
//        categories.add(new Category("Software","Software Category"));
//        categories.add(new Category("Books","Books Category"));
//        users.add(new User("damjan.karadakoski","dk","Damjan","Karadakoski"));
//        users.add(new User("bojana.karadakoski","bk","Bojana","Karadakoski"));
//
//        Manufacturer manufacturer=new Manufacturer("Nike","NY NY");
//        manufacturers.add(manufacturer);
//        Category category=new Category("Sport","Sport Category");
//        categories.add(category);
//        products.add(new Product("Ball 1",234.8,7,category,manufacturer));
//        products.add(new Product("Ball 2",234.8,7,category,manufacturer));
//        products.add(new Product("Ball 3",234.8,7,category,manufacturer));
//    }
}
