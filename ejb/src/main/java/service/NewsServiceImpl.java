package service;

import dao.DAO;
import model.News;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class NewsServiceImpl implements Service {

    @Inject
    private DAO newsDAO;

    @Override
    public List<News> getList() {
        return newsDAO.getList();
    }

    @Override
    public News save(News news) {
        newsDAO.save(news);
        return news;
    }

    @Override
    public boolean remove(int id) {
        return newsDAO.remove(id);
    }

    @Override
    public News fetchById(int id) {
        return newsDAO.fetchById(id);
    }

    @Override
    public News add(News news) {
        newsDAO.add(news);
        return news;
    }
}