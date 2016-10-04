package service;

import model.News;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NewsService {

    List<News> getList();
    String save(News news);
    boolean remove(int id);
    News fetchById(int id);
    String add(News news);
    void removeAll();
}




