package mk.ukim.finki.aud.repository;


import mk.ukim.finki.aud.bootstrap.DataHolder;
import mk.ukim.finki.aud.model.ShopingCart;
import mk.ukim.finki.aud.model.enumerations.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepository {

    public Optional<ShopingCart> findById(Long id){
        return DataHolder.shopingCarts.stream().filter(i ->i.getId().equals(id)).findFirst();
    }

    public Optional<ShopingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status){
        return DataHolder.shopingCarts.stream()
                .filter(i ->i.getUser().getUsername().equals(username) && i.getStatus().equals(status))
                .findFirst();
    }

    public ShopingCart save(ShopingCart shopingCart){
        DataHolder.shopingCarts.removeIf(i->i.getUser().getUsername().equals(shopingCart.getUser().getUsername()));
        DataHolder.shopingCarts.add(shopingCart);
        return shopingCart;
    }


}
