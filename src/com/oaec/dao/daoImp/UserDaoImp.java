package com.oaec.dao.daoImp;

import com.oaec.dao.UserDao;
import com.oaec.domain.User;
import com.oaec.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImp implements UserDao {

    @Override
    public void registe(User user) throws SQLException {
        /**
         * 用户注册
         */
        String sql =  "insert into user values(?,?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday(),user.getIdcard(),user.getEmail(),user.getTelephone(),user.getAddress());
    }

    @Override
    public User login(User user) throws SQLException {
        String sql = "select * from amazon.user where username = ? and password = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return  queryRunner.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
    }
}
