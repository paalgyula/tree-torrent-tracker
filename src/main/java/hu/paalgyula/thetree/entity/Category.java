package hu.paalgyula.thetree.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"category"})
})
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "image", nullable = false)
    private String image;

    @OneToMany(mappedBy = "category")
    private List<Torrent> torrents;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Torrent> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category) {
            return ((Category) obj).getId().equals(this.id);
        } else if (obj instanceof Long) {
            return obj.equals(this.id);
        }
        return super.equals(obj);
    }
}
