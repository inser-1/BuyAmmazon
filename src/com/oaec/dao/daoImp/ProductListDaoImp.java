package com.oaec.dao.daoImp;

import com.oaec.dao.ProductListDao;
import com.oaec.domain.Product;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductListDaoImp implements ProductListDao {
    @Override
    public List<Product> getProductById(String str) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from amazon.product where minorId= ? or majorId = ?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),str,str);
    }

    @Override
    public int findTotal(String pid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from amazon.product where minorid = ? or majorid = ?";
        Long num = (Long) queryRunner.query(sql,new ScalarHandler(),pid,pid);
        return num.intValue();
    }

    @Override
    public List findProductByIdPage(String pid, int startIndex, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from amazon.product where minorId= ? or majorId = ? limit ? , ?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),pid,pid,startIndex,pageSize);
    }
}
