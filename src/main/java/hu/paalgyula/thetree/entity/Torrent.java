package hu.paalgyula.thetree.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2012.10.24.
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "torrents")
public class Torrent {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank
    private String name;

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @Column(name = "checked")
    private boolean checked = false;

    @Column(name = "uploaded")
    private Date uploaded = new Date();

    @Column(name = "downloaded")
    private int downloaded = 0;

    @Column(name = "size")
    private Long size = 0L;

    @Column(name = "info_hash")
    private String infoHash;

    @Column(name = "seeders")
    private int seeders = 0;

    @Column(name = "leechers")
    private int leechers = 0;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @JoinColumn(name = "uploader")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User uploader;

    @Transient
    private Part file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public int getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(int downloaded) {
        this.downloaded = downloaded;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getInfoHash() {
        return infoHash;
    }

    public void setInfoHash(String infoHash) {
        this.infoHash = infoHash;
    }

    public int getSeeders() {
        return seeders;
    }

    public void setSeeders(int seeders) {
        this.seeders = seeders;
    }

    public int getLeechers() {
        return leechers;
    }

    public void setLeechers(int leechers) {
        this.leechers = leechers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
