package com.oaec.dao.daoImp;

import com.oaec.dao.CategoryDao;
import com.oaec.domain.Category;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImp implements CategoryDao {

    @Override
    public List<Category> allCates() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM amazon.product_category;";
        return queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
    }
}
