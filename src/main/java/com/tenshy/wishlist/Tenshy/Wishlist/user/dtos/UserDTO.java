package com.tenshy.wishlist.Tenshy.Wishlist.user.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
public class UserDTO {

    private UUID id;
    private String name;
    private String email;

}
