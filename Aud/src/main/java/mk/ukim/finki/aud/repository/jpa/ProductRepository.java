package mk.ukim.finki.aud.repository.jpa;

import mk.ukim.finki.aud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product>findByName(String name);
    //aku barame eden produkt vaka
    //aku barame pojke raboti so list<>products trebit
    void deleteByName(String name);

}
