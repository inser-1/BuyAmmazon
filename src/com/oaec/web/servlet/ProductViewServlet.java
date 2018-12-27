package com.oaec.web.servlet;

import com.oaec.domain.Product;
import com.oaec.service.ProductViewService;
import com.oaec.service.UserServiceImp.ProductViewServiceImp;
import com.oaec.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends BaseServlet {

    public String findProductById(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String str = req.getParameter("pid");
        Product product = new Product();
        ProductViewService productViewService = new ProductViewServiceImp();
        product = productViewService.getProduct(str);
        System.out.println(product);
        req.setAttribute("Product",product);
        req.getRequestDispatcher("/product_view.jsp").forward(req,resp);
        return null;
    }


}
