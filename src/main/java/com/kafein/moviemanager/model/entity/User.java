package com.kafein.moviemanager.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USER_Name"),
        @UniqueConstraint(columnNames = "EMAIL")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long userId;
    @NotBlank
    @Size(max = 50)
    @Column(name = "USER_NAME")
    private String userName;
    @NotBlank
    @Size(max = 100)
    @Email
    @Column(name = "EMAIL")
    private String email;
    @NotBlank
    @Size(max = 200)
    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "USER_FAVORITES",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "MOVIE_ID") }
    )
    private Set<Movies> favoriteMovies  = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "USER_WATCH_LIST",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "MOVIE_ID") }
    )
    private Set<Movies> userWatchList = new HashSet<>();

}
