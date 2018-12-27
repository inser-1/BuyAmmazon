package com.oaec.web.servlet;

import com.oaec.domain.Product;
import com.oaec.service.HotProductService;
import com.oaec.service.UserServiceImp.HotProductServiceImp;
import com.oaec.web.base.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/HotProductServlet")
public class HotProductServlet extends BaseServlet {

    public String getHotProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HotProductService hotProductService = new HotProductServiceImp();
        List<Product> list = hotProductService.getHotProduct();
       String jsonStr = JSONArray.fromObject(list).toString();
       System.out.println("Hot   "+jsonStr);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(jsonStr);
        return null;
    }
}
