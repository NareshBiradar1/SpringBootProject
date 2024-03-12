package com.scaler.cartservice.Controllers;


import com.scaler.cartservice.Dtos.FakeStoreCartDto;
import com.scaler.cartservice.Models.Cart;
import com.scaler.cartservice.Services.CartService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService=cartService;
    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Naresh..........";
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }


    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable Long id){
        return cartService.getSingleCart(id);
    }

    @GetMapping("/carts?startdate={startDate}&enddate={enddate}")
    public List<Cart> getCartsInRange(@PathVariable String startDate , @PathVariable String enddate ){
        return cartService.getCartsRange(startDate, enddate);
    }

    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCart(@PathVariable Long id){
        return cartService.getUserCart(id);
    }

    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }


    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable Long id){
        return cartService.deleteCart(id);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(@PathVariable Long id , @RequestBody FakeStoreCartDto fakeStoreCartDto){
        return cartService.updateCart(fakeStoreCartDto,id);
    }

}
