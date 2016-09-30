package service;

import dao.DAO;
import model.News;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
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

    private static Logger logger = getLogger(NewsServiceBean.class);
    @Inject
    private DAO newsDAO;
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();
    private News news;

    @PostConstruct
    public void init() {

        for(News news: getList()) {
            checked.put(news.getId().toString(), Boolean.FALSE);
        }
    }

    public NewsServiceBean() {
        logger.info("Creating news");
        this.news = new News();

    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }


    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        this.checked = checked;
    }

    @Override
    public List<News> getList() {
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

        logger.info("Booleans {}", checked);

        logger.error("checked is empty: {}", checked.isEmpty());

        for (Map.Entry<String, Boolean> entry : checked.entrySet()) {

            if (entry.getValue()) {
                newsDAO.remove(Integer.parseInt(entry.getKey()));
            }
        }
    }
}