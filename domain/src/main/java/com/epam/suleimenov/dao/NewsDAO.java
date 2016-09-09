package com.epam.suleimenov.dao;

import com.epam.suleimenov.model.News;

import java.util.List;

public interface NewsDAO {

    List<News> getList();

    News save(News news);

    boolean remove(int id);

    News fetchById(int id);

    /////////

    News add(News news);

}