package com.scaler.cartservice.Dtos;

import com.scaler.cartservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
    private Long userId;

    private String Date ;

    private List<Product> products;
}
