package mk.ukim.finki.aud.model;

import lombok.Data;
import mk.ukim.finki.aud.model.enumerations.ShoppingCartStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ShopingCart {
    private Long id;
    private LocalDateTime dateCreated;
    private User user;
    private List<Product> products;
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
