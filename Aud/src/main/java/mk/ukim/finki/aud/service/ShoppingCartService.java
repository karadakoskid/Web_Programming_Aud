package mk.ukim.finki.aud.service;

import mk.ukim.finki.aud.model.Product;
import mk.ukim.finki.aud.model.ShopingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);
    ShopingCart getActiveShoppingCart(String username);
    ShopingCart addProductToShoppingCart(String username,Long productId);
}
