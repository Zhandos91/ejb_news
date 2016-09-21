package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "News.getAll", query = "select n from News n"),
        @NamedQuery(name = "News.fetchById", query = "select n from News n where n.id = :id")
})
@Table(name = "NEWS")
@Inheritance(strategy = InheritanceType.JOINED)
public class News extends BaseEntity implements Serializable {

    @Column(name = "NEWS_TITLE")
    private String title;
    @Column(name = "NEWS_DATE")
    private String date;
    @Column(name = "NEWS_BRIEF")
    private String brief;
    @Column(name = "NEWS_CONTENT")
    private String content;

    public String getTitle() {
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
