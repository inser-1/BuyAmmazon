package com.oaec.service;

import com.oaec.domain.ShopCar;

import java.util.List;

public interface ShopCartService {
    List<ShopCar> addCart(String pid, String uid, int count) throws Exception;

    List<ShopCar> comeMyCart(String uid) throws  Exception;

    List<ShopCar> delProductFromCart(String uid, String pid) throws Exception;
}
