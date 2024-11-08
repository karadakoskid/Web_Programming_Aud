package mk.ukim.finki.aud.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED) //ne uspeal uslovot
public class ProductAlreadyInShoppingCartException extends RuntimeException{
    public ProductAlreadyInShoppingCartException(Long id,String username) {
        super(String.format("Product with id %d already exist in shopping cart for user with username %s",id,username));
    }
}
