package service;

import dao.DAO;
import model.News;
import org.slf4j.Logger;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

//import org.jboss.logging.Logger;


@Named("NewsManager")
@RequestScoped
public class NewsServiceBean implements NewsService {

    private static Logger logger = getLogger(NewsServiceBean.class);
    @Inject
    private DAO newsDAO;
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();

    @Inject
    private NewsBean newsBean;

    @Inject TestBean testBean;

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getMessage() {

        return "Hello f ejb test!";
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
    public String add() {

//        logger.info("Adding {}", newsBean);
//        logger.info("Adding" + newsBean.getContent());
//        logger.info("Adding", newsBean.getContent());
//        newsDAO.add(this.news);

        FacesContext context = FacesContext.getCurrentInstance();
        NewsBean news = context.getApplication().evaluateExpressionGet(context, "#{News}", NewsBean.class);

        logger.info("News-Content: " + news.getTitle());

        return "index";
    }

    @Override
    public void removeAll() {

//        newsDAO.remove(1059);


        logger.info("RemoveAll");
        logger.info("Edited {}" + checked);

        logger.error("checked is empty: {}", checked.isEmpty());

        for (Map.Entry<String, Boolean> entry : checked.entrySet()) {

            if (entry.getValue()) {
                newsDAO.remove(Integer.parseInt(entry.getKey()));
            }
        }
    }
}