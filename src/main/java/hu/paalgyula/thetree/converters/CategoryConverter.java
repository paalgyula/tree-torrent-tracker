package hu.paalgyula.thetree.converters;

import hu.paalgyula.thetree.entity.Category;
import hu.paalgyula.thetree.repository.CategoryRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by PGYULA on 3/2/14.
 */
@Named
@RequestScoped
public class CategoryConverter implements Converter {
    @Inject
    private CategoryRepository categoryRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return categoryRepository.findById(Long.parseLong(s, 10));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return Long.toString(((Category) o).getId());
    }
}
