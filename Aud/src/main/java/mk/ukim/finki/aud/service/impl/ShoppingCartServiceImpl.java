package mk.ukim.finki.aud.service.impl;



import mk.ukim.finki.aud.model.Product;
import mk.ukim.finki.aud.model.ShopingCart;
import mk.ukim.finki.aud.model.User;
import mk.ukim.finki.aud.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.aud.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.aud.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.aud.model.exceptions.ShoppingCartNotFoundException;
import mk.ukim.finki.aud.model.exceptions.UserNotFoundException;
import mk.ukim.finki.aud.repository.InMemoryShoppingCartRepository;
import mk.ukim.finki.aud.repository.InMemoryUserRepository;
import mk.ukim.finki.aud.service.ProductService;
import mk.ukim.finki.aud.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final InMemoryShoppingCartRepository shoppingCartRepository;
    private final InMemoryUserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(InMemoryShoppingCartRepository shoppingCartRepository,
                                   InMemoryUserRepository userRepository,
                                   ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShopingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository
                .findByUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    User user = this.userRepository.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(username));
                    ShopingCart shoppingCart = new ShopingCart(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShopingCart addProductToShoppingCart(String username, Long productId) {
        ShopingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        if (shoppingCart.getProducts()
                .stream().filter(i -> i.getId().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}



