package com.oaec.dao;

import com.oaec.domain.ShopCar;

import java.util.List;

public interface ShopCartServiceDao {
    ShopCar findCartItem(String uid, String pid) throws Exception;

    int addCart(String pid, String uid, int count) throws Exception;

    int addProductToCart(String pid, String uid, int count) throws Exception;

    List<ShopCar> findMyCart(String uid) throws Exception;

    void delProductFromCart(String uid, String pid) throws  Exception;
}
