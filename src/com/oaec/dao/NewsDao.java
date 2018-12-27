package com.oaec.dao;

import com.oaec.domain.News;

import java.util.List;

public interface NewsDao {
    List<News> getNews() throws Exception;
}
