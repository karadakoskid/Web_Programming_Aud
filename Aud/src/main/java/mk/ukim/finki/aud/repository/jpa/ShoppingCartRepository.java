package mk.ukim.finki.aud.repository.jpa;

import mk.ukim.finki.aud.model.ShopingCart;
import mk.ukim.finki.aud.model.User;
import mk.ukim.finki.aud.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShopingCart,Long> {
    Optional<ShopingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
