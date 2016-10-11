package service;

import dao.DAO;
import model.News;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;


@Stateless(name = "NewsService")
@WebService(name = "NewsService",
            portName = "NewsServicePort",
            targetNamespace = "https://epam.com/suleimenov/service/newsService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class NewsServiceBean implements NewsService {

    @EJB(lookup = "java:module/NewsJPADaoImpl")
    private DAO newsDAO;

    @WebMethod(operationName = "GetNewsList")
    @WebResult(name = "NewsList")
    @Override
    public List<News> getList() {
        return newsDAO.getList();
    }

    @WebMethod(operationName = "SaveNews")
    @WebResult(name = "News")
    @Override
    public News save(News news) {
        newsDAO.save(news);
        return news;
    }

    @WebMethod(operationName = "RemoveNews")
    @WebResult(name = "News")
    public boolean remove(@WebParam(name = "NewsPrimaryKey") int id) {
        return newsDAO.remove(id);
    }

    @WebMethod(operationName = "GetNews")
    @WebResult(name = "News")
    public News fetchById(@WebParam(name = "NewsPrimaryKey") int id) {
        return newsDAO.fetchById(id);
    }

    @WebMethod(operationName = "AddNews")
    @WebResult(name = "News")
    @Override
    public News add(News news) {
        newsDAO.add(news);
        return news;
    }
}