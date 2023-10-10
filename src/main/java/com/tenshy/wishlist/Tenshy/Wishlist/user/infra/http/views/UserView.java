package com.tenshy.wishlist.Tenshy.Wishlist.user.infra.http.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
public class UserView {

    private UUID id;
    private String name;
    private String email;

}
