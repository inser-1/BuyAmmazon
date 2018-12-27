package com.oaec.web.servlet;

import com.oaec.domain.PageModel;
import com.oaec.domain.Product;
import com.oaec.service.ProductListService;
import com.oaec.service.UserServiceImp.ProductListServiceImp;
import com.oaec.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/ProductSortServlet")
public class ProductSortServlet extends BaseServlet {

    public String findAllProductById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       String str = req.getParameter("pid");
       System.out.println(str);
        ProductListService productListService = new ProductListServiceImp();
        List<Product> list = productListService.getProductById(str);
        System.out.println("ProductSortServlet "+list);
        resp.setContentType("application/json;charset=utf-8");
        req.setAttribute("ProductList",list);
        req.getRequestDispatcher("/product-list.jsp").forward(req,resp);
        return "product-list.jsp";
    }
    public String findAllProductByIdPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pid = req.getParameter("pid");
        int num = Integer.parseInt(req.getParameter("num"));
        ProductListService productListService = new ProductListServiceImp();
        PageModel pm = productListService.findProductByIdPage(pid,num);
        req.setAttribute("page",pm);
        return "product-list.jsp";
    }
}
