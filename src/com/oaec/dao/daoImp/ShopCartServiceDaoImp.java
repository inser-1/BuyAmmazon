package com.oaec.dao.daoImp;

import com.oaec.dao.ShopCartServiceDao;
import com.oaec.domain.ShopCar;
import com.oaec.domain.ShopCart;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class ShopCartServiceDaoImp implements ShopCartServiceDao {
    @Override
    public ShopCar findCartItem(String uid, String pid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM amazon.shop_cart where `uid` = ?  and `pid` = ? ";
        ShopCar shopCar = queryRunner.query(sql,new BeanHandler<ShopCar>(ShopCar.class),uid,pid);
        return shopCar;
    }

    @Override
    public int addCart(String pid, String uid, int count) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO `amazon`.`shop_cart` ( `pid`, `pnum`, `uid`) VALUES ( ?, ?, ?)";
        return  queryRunner.update(sql,pid,count,uid);

    }

    @Override
    public int addProductToCart(String pid, String uid, int count) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "UPDATE `amazon`.`shop_cart` SET `pnum`=`pnum`+? WHERE `uid`=? and `pid` = ?";
        return queryRunner.update(sql,count,uid,pid);
    }

    @Override
    public List<ShopCar> findMyCart(String uid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM amazon.shop_cart cart,amazon.product product where cart.uid= ? and cart.pid = product.id ";
        List<ShopCart> list = queryRunner.query(sql,new BeanListHandler<ShopCart>(ShopCart.class),uid);
        return queryRunner.query(sql,new BeanListHandler<ShopCar>(ShopCar.class),uid);
    }

    @Override
    public void delProductFromCart(String uid, String pid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        //DELETE FROM `amazon`.`shop_cart` WHERE `id`='13';
        String sql = "DELETE FROM `amazon`.`shop_cart` WHERE `uid`=? AND `pid`=? ";
        queryRunner.update(sql,uid,pid);

    }
}
