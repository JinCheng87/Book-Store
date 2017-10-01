package com.bookstore.service;

import com.bookstore.domain.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart clearShoppingCart(ShoppingCart shoppingCart);
}
