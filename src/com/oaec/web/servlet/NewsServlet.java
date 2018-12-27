package com.oaec.web.servlet;

import com.oaec.domain.News;
import com.oaec.service.NewsService;
import com.oaec.service.UserServiceImp.NewsServiceImp;
import com.oaec.web.base.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {
    public String getNews(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        /**
         * 获取新闻
         */
        NewsService newsService = new NewsServiceImp();
        List<News> list =  newsService.getNews();
        String jsonStr = JSONArray.fromObject(list).toString();
        System.out.println(jsonStr);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(jsonStr);
        return null;
    }

}
