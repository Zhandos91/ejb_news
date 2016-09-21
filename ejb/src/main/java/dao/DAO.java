package dao;

import model.News;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DAO {

    List<News> getList();

    News save(News news);

    boolean remove(int id);

    News fetchById(int id);

    /////////

    News add(News news);

}