package mk.ukim.finki.aud.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.aud.model.enumerations.ShoppingCartStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShopingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreated;
    @ManyToOne//pojke korpi za eden coek
    private User user;
    @ManyToMany //poveke shopping carts kun pojke produkti zs mojot pojke produkti da se staet vo pojke shoppingcarts deka eden coek mojt da imat pojke shopping carts
    private List<Product> products;
    @Enumerated(EnumType.STRING) //davat status CREATED, CANCELED, FINISHED
    private ShoppingCartStatus status;

    public ShopingCart() {
        this.id=(long)(Math.random() *1000);
    }

    public ShopingCart( User user) {
        this.id=(long)(Math.random() *1000);
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.products =new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
