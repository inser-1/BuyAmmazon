package com.oaec.web.servlet;

import com.oaec.domain.Category;
import com.oaec.service.CategoryService;
import com.oaec.service.UserServiceImp.CategoryServiceImp;
import com.oaec.utils.JedisPoolUtils;
import com.oaec.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
    public String findAllCates(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        CategoryService categoryService = new CategoryServiceImp();
        Jedis jedis = JedisPoolUtils.getJedis();
        String categoryListJson = jedis.get("categoryListJson");
        if (categoryListJson == null) {
            System.out.println("缓存无内容");
            List<Category> list =  categoryService.getAllCates();
            categoryListJson= JSONArray.fromObject(list).toString();
            jedis.set("categoryListJson",categoryListJson);
        }
        System.out.println("缓存有内容");
        System.out.println(categoryListJson);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(categoryListJson);
        return null;
    }
}
