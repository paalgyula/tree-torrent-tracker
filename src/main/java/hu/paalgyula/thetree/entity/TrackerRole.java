package hu.paalgyula.thetree.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by paalgyula on 2013.11.02..
 */
@Entity
@Table(name="tracker_role")
public class TrackerRole {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="USER_ID")}, inverseJoinColumns = {@JoinColumn(name="ROLE_ID")})
    private Collection<User> trackerUsers;

    public Collection<User> getTrackerUsers() {
        return trackerUsers;
    }

    public void setTrackerUsers(Collection<User> trackerUsers) {
        this.trackerUsers = trackerUsers;
    }
}
