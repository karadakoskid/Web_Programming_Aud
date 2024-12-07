package mk.ukim.finki.aud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name="shop-users")
public class User {
    @Id
    private String username;

    private String password;
    private String name;
    private String surname;
    //ToMany se LAZY, ToOne se EAGER ova e po default
    //mappedBy="imeto" se stavat za da ne se kreira tehnicki dupla tabela za shop-users carts
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)//eden user kun poveke shoppingcarts
    private List<ShopingCart> carts;
    //za ovaj user gi naojgame site kosnicki
    //odnosno gi vrajkame site kosnicki so gi imat ovaj user
    //ne e okey vaka da se prajt, ova najubo bilo da se prajt preku repository
    public User() {

    }
    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


}
