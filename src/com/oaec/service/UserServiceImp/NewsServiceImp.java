package com.oaec.service.UserServiceImp;

import com.oaec.dao.NewsDao;
import com.oaec.dao.daoImp.NewsDaoImp;
import com.oaec.domain.News;
import com.oaec.service.NewsService;

import java.util.List;

public class NewsServiceImp implements NewsService {
    @Override
    public List<News> getNews() throws Exception {
        NewsDao newsDao = new NewsDaoImp();
        return newsDao.getNews();
    }
}
