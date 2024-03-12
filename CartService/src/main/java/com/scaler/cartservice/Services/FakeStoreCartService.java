package com.scaler.cartservice.Services;

import com.scaler.cartservice.Dtos.FakeStoreCartDto;
import com.scaler.cartservice.Models.Cart;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreCartService implements CartService{

    private RestTemplate restTemplate = new RestTemplate();

    private String url = "https://fakestoreapi.com/carts";
    @Override
    public List<Cart> getAllCarts() {

        List<Cart> allCarts = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cart>>() {
                }
        ).getBody();
        return allCarts;
    }

    @Override
    public Cart getSingleCart(Long id) {
        Cart cart = restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Cart>() {
                }
        ).getBody();
        return cart;
    }

    @Override
    public List<Cart> getCartsRange(String startDate, String endDate) {
        List<Cart> allCarts = restTemplate.exchange(
                url + "?startdate="+startDate+"&enddate="+endDate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cart>>() {
                }
        ).getBody();
        return null;
    }

    @Override
    public List<Cart> getUserCart(Long id) {
        List<Cart> allCarts = restTemplate.exchange(
                url + "/user/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cart>>() {
                }
        ).getBody();
        return allCarts;
    }

    @Override
    public Cart addCart(Cart cart) {
        Cart returnedcart = restTemplate.postForObject(url , cart , Cart.class);
        return returnedcart;
    }

    @Override
    public Cart updateCart(FakeStoreCartDto fakeStoreCartDto, Long id) {
        Cart cart = setCart(fakeStoreCartDto , id);
        restTemplate.put(url+"/"+id,fakeStoreCartDto);
        return cart;
    }


    @Override
    public Cart deleteCart(Long id) {
        Cart cart = getSingleCart(id);
        restTemplate.delete(url+"/"+id);
        return cart;
    }

    public Cart setCart(FakeStoreCartDto fakeStoreCartDto , Long id){
        Cart cart = new Cart();
        cart.setId(id);
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setProducts(fakeStoreCartDto.getProducts());
        return cart;
    }
}
