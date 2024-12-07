package mk.ukim.finki.aud.repository.jpa;

import jakarta.persistence.Entity;
import mk.ukim.finki.aud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    List<Category> findAllByNameLike(String text);//za slicno zatoa e like,nemorat da e tocno ime za da go najt mojt i slicno
    //na pr ak barame Damjan, da napisime Dam i ke izlezit Damjan

    void deleteByName(String name);
}
