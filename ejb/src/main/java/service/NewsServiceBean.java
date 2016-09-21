package service;

import dao.DAO;
import model.News;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

//import javax.inject.Inject;

//import javax.enterprise.context.RequestScoped;

//@Stateless(name = "NewsService")
@Named("NewsManager")
//@ManagedBean(name = "NewsManager")
@RequestScoped
public class NewsServiceBean implements NewsService {

    @Inject
    private DAO newsDAO;

    public String getMessage() {
        return "Hello f ejb test!";
    }


    @Override
    public List<News> getList() {
//        List<News> news = new ArrayList<>();
//        News n = new News();
//        n.setTitle("bane");
//        News n2 = new News();
//        n2.setTitle("crane");
//        news.add(n);
//        news.add(n2);
//        return news;
        return newsDAO.getList();
    }

    @Override
    public News save(News news) {
        return newsDAO.save(news);
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
        return newsDAO.add(news);
    }
}