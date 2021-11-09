package com.example.shopcat1.services;

import com.example.shopcat1.models.Cart;
import com.example.shopcat1.repositories.CartRepository;
import java.util.List;

@Service
public class CartServices {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> getAllItems(){
        return cartRepository.findAll();
    }

    public Cart createItem(String name, String item, int unitPrice){
        Cart cart = new Cart(name,item, unitPrice);
        return  CartRepository.save(cart);
    }


    public void deleteItem(Integer id){
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Item not found on the cart with id"+ id));
        cartRepository.deleteById(id);
    }

    public Cart updateItem(Integer id, Cart cart){
        cartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Item not found on the cart with id"+ id));

        cart.setId(id);

        return cartRepository.save(cart);

    }

}
