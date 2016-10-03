package service;

import model.News;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Named
@RequestScoped
public class TestBean {

    private List<News> items;
    private static Logger logger = getLogger(TestBean.class);
    private Map<Integer,Boolean> checkMap = new HashMap<Integer,Boolean>();


    public TestBean() {
        items = new ArrayList<News>();
        News news = new News();
        news.setId(1);
        items.add(news);
        news = new News();
        news.setId(2);
        items.add(news);
        news = new News();
        news.setId(3);
        items.add(news);
        news = new News();
        news.setId(4);
        items.add(news);
        news = new News();
        news.setId(5);
        items.add(news);
        news = new News();
        news.setId(6);
        items.add(news);
        news = new News();
        news.setId(7);
        items.add(news);

        //fill the check map with the items defaulted to unchecked
        for (News item : items) {
            checkMap.put(item.getId(),Boolean.TRUE);
        }
    }

    public List<News> getItems() {
        return items;
    }

    public Map<Integer, Boolean> getCheckMap() {
        return checkMap;
    }

    public String getSelected() {
        logger.info("Map {}", checkMap);
        String result = "";
        for (Map.Entry<Integer,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                result = result + ", "+entry.getKey();
            }
        }
        return result.length() == 0 ? "" : result.substring(2);
    }


}
