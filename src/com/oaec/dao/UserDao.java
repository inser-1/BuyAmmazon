package com.oaec.dao;

import com.oaec.domain.User;

import java.sql.SQLException;

public interface UserDao {
    void registe(User user) throws SQLException;

    User login(User user) throws SQLException;
}
