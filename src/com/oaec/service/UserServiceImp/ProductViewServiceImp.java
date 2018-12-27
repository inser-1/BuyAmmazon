package com.oaec.service.UserServiceImp;

import com.oaec.dao.ProductViewDao;
import com.oaec.dao.daoImp.ProductViewDaoImp;
import com.oaec.domain.Product;
import com.oaec.service.ProductViewService;

public class ProductViewServiceImp implements ProductViewService {

    @Override
    public Product getProduct(String str) throws Exception {
        ProductViewDao productViewDao = new ProductViewDaoImp();
        Product product = productViewDao.getProduct(str);
        return product;
    }
}
