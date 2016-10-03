package service;

import dao.DAO;
import model.News;
import org.slf4j.Logger;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;


@Named("NewsManager")
@RequestScoped

public class NewsServiceBean implements NewsService {

    private static Logger logger = getLogger(NewsService.class);
    @Inject
    private DAO newsDAO;
    private News news;
    @Inject
    TestBean testBean;
//    private List<News> items;

    private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();

//    @PostConstruct
//    public void NewsServiceBean() {
//        items = newsDAO.getList();
//    }

//    public List<News> getItems() {
//        return items;
//    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

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

//        FacesContext context = FacesContext.getCurrentInstance();
//        NewsBean news = context.getApplication().evaluateExpressionGet(context, "#{News}", NewsBean.class);

//        logger.info("News-Content: " + news.getTitle());

        return "index";
    }

    @Override
    public void removeAll() {

//        newsDAO.remove(1059);

        logger.info("Booleans {}", testBean.getCheckMap());

        logger.error("checked is empty: {}", testBean.getCheckMap().isEmpty());

        for (Map.Entry<Integer, Boolean> entry : testBean.getCheckMap().entrySet()) {

            if (entry.getValue()) {
                newsDAO.remove(entry.getKey());
            }
        }
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
    }

//    public String getSelected() {
//        logger.info("Map {}", this.checked);
//        logger.info("Map is empty " + this.checked.isEmpty());
//        String result = "";
//        for (Map.Entry<Integer,Boolean> entry : checked.entrySet()) {
//            if (entry.getValue()) {
//                result = result + ", "+entry.getKey();
//            }
//        }
//        return result.length() == 0 ? "" : result.substring(2);
//    }


    public String getSelected() {
        logger.info("Map {}", checked);
        String result = "";
        for (Map.Entry<Integer,Boolean> entry : checked.entrySet()) {
            if (entry.getValue()) {
                result = result + ", "+entry.getKey();
            }
        }
        return result.length() == 0 ? "" : result.substring(2);
    }
}