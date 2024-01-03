package com.carRentalSystem.domain;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //parent class, has children =>customer and Admin, (i will try a single table later)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username", length = 20, nullable = false) //@Notnull, I can use @Size(min =20)
    private String userName;
    @Column(name="password", nullable = false)
    private String passWord;

    private Boolean active;
    @Transient //field wont be mapped to db
    private Boolean admin;

    //mappedBy would only be used for bi-directionals, and put on the side of onetomany(MappedBy), below is uni-directional. ALSO 1TO1 BI =>JoinColumn by default, we choose a mappedby side
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) //One to many->lazy loading// cascade.persist,if entity saved, associated ones will also get saved
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Order> orders;

    @ManyToMany
    private List<Role>roles = new ArrayList<>();

}
