package com.oaec.dao;

import com.oaec.domain.Product;

import java.util.List;

public interface HotProductDao {
    List<Product> getHotProduct() throws Exception;
}
