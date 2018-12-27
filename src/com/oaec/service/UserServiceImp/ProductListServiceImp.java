package com.oaec.service.UserServiceImp;

import com.oaec.dao.ProductListDao;
import com.oaec.dao.daoImp.ProductListDaoImp;
import com.oaec.domain.PageModel;
import com.oaec.domain.Product;
import com.oaec.service.ProductListService;

import java.util.List;

public class ProductListServiceImp implements ProductListService {
    @Override
    public List<Product> getProductById(String str) throws Exception {
        ProductListDao productListDao = new ProductListDaoImp();
        return productListDao.getProductById(str) ;
    }

    @Override
    public PageModel findProductByIdPage(String pid, int num) throws Exception {
        ProductListDao productListDao = new ProductListDaoImp();
        int total = productListDao.findTotal(pid);
        PageModel pageModel = new PageModel(num,total,12);
        List list = productListDao.findProductByIdPage(pid,pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        pageModel.setUrl("ProductSortServlet?method=findAllProductByIdPage&pid="+pid);
        return pageModel;
    }
}
