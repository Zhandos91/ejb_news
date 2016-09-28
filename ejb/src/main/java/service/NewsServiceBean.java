package service;

import dao.DAO;
import model.News;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("NewsManager")
@RequestScoped
public class NewsServiceBean implements NewsService {

    @Inject
    private DAO newsDAO;

    private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();

    public String getMessage() {
        return "Hello f ejb test!";
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
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
    public News add(News news) {
        return newsDAO.add(news);
    }

    @Override
    public void removeAll() {

        for (Map.Entry<Integer, Boolean> entry : checked.entrySet()) {
            if (entry.getValue()) {
                newsDAO.remove(entry.getKey());
            }
        }
    }
}