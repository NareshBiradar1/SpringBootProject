package com.scaler.cartservice.Services;
import com.scaler.cartservice.Dtos.FakeStoreCartDto;
import com.scaler.cartservice.Models.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getAllCarts();

    Cart getSingleCart(Long id);

    List<Cart> getCartsRange(String startDate , String endDate);

    List<Cart> getUserCart(Long id);

    Cart addCart(Cart cart);

    Cart updateCart(FakeStoreCartDto fakeStoreCartDto, Long id);


    Cart deleteCart(Long id);

}
