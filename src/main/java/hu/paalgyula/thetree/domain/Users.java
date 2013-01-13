package hu.paalgyula.thetree.domain;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2012.10.24.
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String password2;

    @Column(name="email")
    private String email;

    @Column(name="registred")
    private Date registred = new Date();

    @Column(name="lastlogin")
    private Date lastlogin;

    @Column(name="points")
    private int points = 0;

    @Column(name="uploaded")
    private long uploaded = 0L;

    @Column(name="downloaded")
    private long downloaded = 0L;

    @Column(name="title")
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void encodePassword() {
        this.password = new Md5PasswordEncoder().encodePassword( this.password, null );
    }
}
