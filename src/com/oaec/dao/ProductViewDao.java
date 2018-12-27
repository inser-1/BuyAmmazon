package com.oaec.dao;

import com.oaec.domain.Product;

public interface ProductViewDao {

    Product getProduct(String str) throws Exception;
}
