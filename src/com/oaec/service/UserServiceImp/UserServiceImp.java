package com.oaec.service.UserServiceImp;

import com.oaec.dao.UserDao;
import com.oaec.dao.daoImp.UserDaoImp;
import com.oaec.domain.User;
import com.oaec.service.UserService;

import java.sql.SQLException;

public class UserServiceImp implements UserService {
    @Override
    public void registe(User user) throws SQLException {
        /**
         *用户注册
         */
        UserDao userDao = new UserDaoImp();
        userDao.registe(user);
    }

    @Override
    public User login(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        User user1 = userDao.login(user);
        if(null == user1){
            throw new RuntimeException("密码错误");
        }else {
            return user1;
        }
    }
}
