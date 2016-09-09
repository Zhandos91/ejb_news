package com.epam.suleimenov.dao;

import com.epam.suleimenov.model.News;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class JPADAO implements NewsDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<News> getList() {
        TypedQuery<News> query = entityManager.createNamedQuery("News.getAll", News.class);
        List<News> list = query.getResultList();
        return list;
    }

    @Transactional
    @Override
    public News save(News news) {
        entityManager.merge(news);
        return news;
    }

    @Transactional
    @Override
    public boolean remove(int id) {
        News n = entityManager.find(News.class, id);
        entityManager.remove(n);
        return true;
    }

    @Override
    public News fetchById(int id) {
        TypedQuery<News> query = entityManager.createNamedQuery("News.fetchById", News.class);
        query.setParameter("id", id);
        News news = query.getSingleResult();
        return news;
    }

    @Transactional
    @Override
    public News add(News news) {
        entityManager.persist(news);
        return news;
    }
}
