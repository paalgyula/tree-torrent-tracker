package hu.paalgyula.thetree.entity;

import java.security.Principal;
import java.util.Date;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2012.10.24.
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Cacheable
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u order by u.id asc", hints = {
                @QueryHint(name = "javax.persistence.cache.storeMode", value = "REFRESH"),
                @QueryHint(name = "javax.persistence.cache.retrieveMode", value = "USE")
        })
})
public class User implements Principal {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String password2;

    @Column(name = "email")
    private String email;

    @Column(name = "registred")
    private Date registred = new Date();

    @Column(name = "lastlogin")
    private Date lastlogin;

    @Column(name = "points")
    private int points = 0;

    @Column(name = "uploaded")
    private long uploaded = 0L;

    @Column(name = "downloaded")
    private long downloaded = 0L;

    @Column(name = "title")
    private String title = "Újonc";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistred() {
        return registred;
    }

    public void setRegistred(Date registred) {
        this.registred = registred;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getUploaded() {
        return uploaded;
    }

    public void setUploaded(long uploaded) {
        this.uploaded = uploaded;
    }

    public long getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(long downloaded) {
        this.downloaded = downloaded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    @Transient
    public String getName() {
        return this.username;
    }
}
