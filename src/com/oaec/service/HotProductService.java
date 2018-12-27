package com.oaec.service;

import com.oaec.domain.Product;

import java.util.List;

public interface HotProductService {
    List<Product> getHotProduct() throws Exception;
}
