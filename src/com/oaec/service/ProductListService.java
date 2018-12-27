package com.oaec.service;

import com.oaec.domain.PageModel;
import com.oaec.domain.Product;

import java.util.List;

public interface ProductListService  {
    List<Product> getProductById(String str) throws  Exception;

    PageModel findProductByIdPage(String pid, int num)throws  Exception;
}
