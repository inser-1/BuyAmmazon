package com.oaec.dao.daoImp;

import com.oaec.dao.NewsDao;
import com.oaec.domain.News;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class NewsDaoImp implements NewsDao {
    @Override
    public List<News> getNews() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM amazon.news;";
        return queryRunner.query(sql,new BeanListHandler<News>(News.class));
    }
}
