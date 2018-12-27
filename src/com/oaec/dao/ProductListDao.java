package com.oaec.dao;

import com.oaec.domain.Product;

import java.util.List;

public interface ProductListDao {
    List<Product> getProductById(String str) throws Exception;

    int findTotal(String pid) throws Exception;

    List findProductByIdPage(String pid, int startIndex, int pageSize) throws  Exception;
}
