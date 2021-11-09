package com.example.shopcat1.services;

import com.example.shopcat1.models.Cart;
import com.example.shopcat1.repositories.CartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartServices cartServices;

    @Test
    public void returnCart(){
        when(cartRepository.findAll()).thenReturn(Arrays.asList(
                new Cart("M002","chocolate",500),
                new Cart("P001","bonbon", 100)));
        assertEquals("P001",cartServices.getAllItems().get(1).getCode());
    }

    @Test
    public  void createItem(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(new Cart("SE01","Juice",400));
        assertEquals("SE01",cartRepository.createItem("M001","biscuits",, 1).getCode());
    }

    @Test
    public void deleteItem(){
        Cart cr = new Cart("M002","meat",300);
        when(cartRepository.findById(cr.getId())).thenReturn(Optional.of(cr));
        cartServices.deleteItem(cr.getId());
        verify(cartRepository).deleteById(cr.getId());
    }

    @Test
    public void updateItem(){
        Cart cr = new Cart("P002","Pizza",2000);
        Cart newCr = new Cart("B003","Burger", 1000);
        given(cartRepository.findById(cr.getId())).willReturn(Optional.of(cr));

        cartServices.updateItem(cr.getId(),newCr);
        verify(cartRepository).save(newCr);
        verify(cartRepository).findById(cr.getId());
    }
}
