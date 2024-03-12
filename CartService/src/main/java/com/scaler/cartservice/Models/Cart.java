package com.scaler.cartservice.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {

    private Long id;

    private Long userId;

    private String Date ;

    private List<Product> products;

}
