package service;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named("News")
@RequestScoped
public class NewsBean {

    private String title;
    private String date;
    private String brief;
    private String content;
    private Integer id;

    public String getTitle() {

//
//        Map<String, String> params =FacesContext.getCurrentInstance().
//                getExternalContext().getRequestParameterMap();
//         title = params.get("title");

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
