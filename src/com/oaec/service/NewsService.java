package com.oaec.service;

import com.oaec.domain.News;

import java.util.List;

public interface NewsService {
    List<News> getNews() throws Exception;
}
