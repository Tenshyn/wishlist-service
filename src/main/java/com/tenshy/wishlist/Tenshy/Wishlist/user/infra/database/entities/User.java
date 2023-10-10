package com.tenshy.wishlist.Tenshy.Wishlist.user.infra.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity(name = "wl_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Accessors(chain = true)
public class User {

    @Id
    @Column(name = "wu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "wu_name")
    private String name;
    @Column(name = "wu_email")
    private String email;

}
