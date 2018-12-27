package com.oaec.dao.daoImp;

import com.oaec.dao.ProductViewDao;
import com.oaec.domain.Product;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class ProductViewDaoImp implements ProductViewDao {


    @Override
    public Product getProduct(String str) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM amazon.product where id = ?";
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),str);
    }
}
