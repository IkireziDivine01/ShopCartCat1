package com.example.shopcat1.controllers;

import com.example.shopcat1.services.CartServices;
import com.example.shopcat1.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Cart {
    @Autowired
    CartServices cartServices;

    @GetMapping("/get-all")
    public List<Cart> getAll(){
        return cartServices.getAllItems();
    }

    @PostMapping("/add-item")
    public Cart addItem(@RequestBody Cart cart){
        return cartServices.createItem(cart.getName(), cart.getItem(),cart.getUnitPrice());
    }

    @PostMapping("/edit-item/{courseId}")
    public Cart editItem(@RequestBody Cart cart, @PathVariable Integer catId){
        return cartServices.updateItem(catId, cart);
    }
}
