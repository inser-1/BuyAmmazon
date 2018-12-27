package com.oaec.dao;

import com.oaec.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> allCates() throws Exception;
}
