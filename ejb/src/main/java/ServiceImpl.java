import com.epam.suleimenov.dao.NewsDAO;
import com.epam.suleimenov.model.News;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ServiceImpl implements Service {

    @EJB
    private NewsDAO newsDAO;

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
}