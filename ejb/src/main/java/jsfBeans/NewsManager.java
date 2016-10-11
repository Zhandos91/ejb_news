package jsfBeans;

import model.News;
import org.slf4j.Logger;
import service.NewsService;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Named
@RequestScoped
public class NewsManager {

    private static Logger logger = getLogger(NewsService.class);
    @EJB(beanName = "NewsService")
    NewsService service;
    @Inject CheckBoxHandler checkBoxHandler;

    public List<News> getList() {
        logger.info("I'm getting the list");
        return service.getList();
    }

    public String save(News news) {
        logger.info("Saving News: {}", news);
        service.save(news);
        return "index";
    }

    public String remove(int id) {
        service.remove(id);
        return "index";
    }

    public News fetchById(int id) {
        return service.fetchById(id);
    }

    public String add(News news) {
        logger.info("Adding News {}", news);
        service.add(news);
        return "index";
    }

    public void removeAll() {

        logger.info("Booleans {}", checkBoxHandler.getCheckMap());
        for (Map.Entry<Integer, Boolean> entry : checkBoxHandler.getCheckMap().entrySet()) {
            if (entry.getValue()) {
                service.remove(entry.getKey());
            }
        }
    }
}
