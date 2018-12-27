package com.oaec.service.UserServiceImp;

import com.oaec.dao.HotProductDao;
import com.oaec.dao.daoImp.HotProductDaoImp;
import com.oaec.domain.Product;
import com.oaec.service.HotProductService;

import java.util.List;

public class HotProductServiceImp implements HotProductService {
    @Override
    public List<Product> getHotProduct() throws Exception {
        HotProductDao hotProductDao = new HotProductDaoImp();
        return hotProductDao.getHotProduct();
    }
}
