package hu.paalgyula.thetree.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by PGYULA on 3/2/14.
 */
@Entity
@Cacheable
@XmlRootElement
public class FeedItem {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_date")
    private Date postDate = new Date();

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Basic
    @Column(name = "content")
    private String feedContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedContent() {
        return feedContent;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
