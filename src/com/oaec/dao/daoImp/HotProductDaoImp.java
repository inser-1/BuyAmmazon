package com.oaec.dao.daoImp;

import com.oaec.dao.HotProductDao;
import com.oaec.domain.Product;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class HotProductDaoImp implements HotProductDao {
    @Override
    public List<Product> getHotProduct() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from amazon.product_hot";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class));
    }
}
