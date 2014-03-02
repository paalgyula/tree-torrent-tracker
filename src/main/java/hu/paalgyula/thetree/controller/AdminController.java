package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.Category;
import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.repository.CategoryRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Created by PGYULA on 3/2/14.
 */
@Model
public class AdminController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private FacesContext facesContext;

    private Torrent selectedTorrent;
    private Category newCategory;

    @PostConstruct
    public void initAdmin() {
        this.initNewCategory();
    }

    private void initNewCategory() {
        this.newCategory = new Category();
    }

    // Controller methods
    public void addCategory() {
        this.categoryRepository.save(this.newCategory);
        this.initNewCategory();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Siker!", "A kategória sikeresen mentve!"));
    }

    public Torrent getSelectedTorrent() {
        return selectedTorrent;
    }

    public void setSelectedTorrent(Torrent selectedTorrent) {
        this.selectedTorrent = selectedTorrent;
    }

    public Category getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }
}
