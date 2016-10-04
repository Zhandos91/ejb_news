package service;

import dao.DAO;
import model.News;
import org.slf4j.Logger;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;


@Named("NewsManager")
@RequestScoped
public class NewsServiceBean implements NewsService {

    private static Logger logger = getLogger(NewsService.class);
    @Inject
    private DAO newsDAO;
    @Inject
    CheckBoxHandler checkBoxHandler;

    @Override
    public List<News> getList() {
        logger.info("I'm getting the list");
        return newsDAO.getList();
    }

    @Override
    public News save(News news) {

        logger.info("News: {}", news);

        return news;


//        return newsDAO.save(news);
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
    public String add(News news) {
        logger.info("Adding {}", news);
        newsDAO.add(news);
        return "index";
    }

    @Override
    public void removeAll() {

        logger.info("Booleans {}", checkBoxHandler.getCheckMap());

        logger.error("checked is empty: {}", checkBoxHandler.getCheckMap().isEmpty());

        for (Map.Entry<Integer, Boolean> entry : checkBoxHandler.getCheckMap().entrySet()) {

            if (entry.getValue()) {
                newsDAO.remove(entry.getKey());
            }
        }
    }
}