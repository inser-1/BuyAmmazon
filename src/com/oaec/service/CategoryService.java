package com.oaec.service;

import com.oaec.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCates() throws Exception;
}
