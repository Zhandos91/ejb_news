package service;

import model.News;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("NewsBean")
@RequestScoped
public class NewsBean implements Serializable {

    private News news = new News();

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
