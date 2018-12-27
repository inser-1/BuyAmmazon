package com.oaec.service;

import com.oaec.domain.User;

import java.sql.SQLException;

public interface UserService {
    void registe(User user) throws SQLException;

    User login(User user) throws SQLException;
}
