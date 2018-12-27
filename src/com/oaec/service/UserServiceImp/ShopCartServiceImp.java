package com.oaec.service.UserServiceImp;

import com.oaec.dao.ShopCartServiceDao;
import com.oaec.dao.daoImp.ShopCartServiceDaoImp;
import com.oaec.domain.ShopCar;
import com.oaec.service.ShopCartService;

import java.util.List;

public class ShopCartServiceImp implements ShopCartService {
    @Override
    public List<ShopCar> addCart(String pid, String uid, int count) throws Exception {
        ShopCartServiceDao shopCartServiceDao = new ShopCartServiceDaoImp();
        if (pid != null){
        ShopCar shopCar = shopCartServiceDao.findCartItem(uid,pid);
        if (shopCar == null){
            shopCartServiceDao.addCart(pid,uid,count);
            return shopCartServiceDao.findMyCart(uid);
        }else {
           shopCartServiceDao.addProductToCart(pid,uid,count);
            return shopCartServiceDao.findMyCart(uid);
        }
        }else {
            return shopCartServiceDao.findMyCart(uid);
        }
    }

    @Override
    public List<ShopCar> comeMyCart(String uid) throws Exception {
        ShopCartServiceDao shopCartServiceDao = new ShopCartServiceDaoImp();
        return shopCartServiceDao.findMyCart(uid);
    }

    @Override
    public List<ShopCar> delProductFromCart(String uid, String pid) throws Exception {
        ShopCartServiceDao shopCartServiceDao = new ShopCartServiceDaoImp();
        shopCartServiceDao.delProductFromCart(uid,pid);
        return shopCartServiceDao.findMyCart(uid);
    }


}
