package com.oaec.service.UserServiceImp;

import com.oaec.dao.CategoryDao;
import com.oaec.dao.daoImp.CategoryDaoImp;
import com.oaec.domain.Category;
import com.oaec.service.CategoryService;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    @Override
    public List<Category> getAllCates() throws Exception {
        CategoryDao categoryDao = new CategoryDaoImp();
        return categoryDao.allCates();
    }
}
