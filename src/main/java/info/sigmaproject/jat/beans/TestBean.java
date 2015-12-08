package info.sigmaproject.jat.beans;

import info.sigmaproject.jat.entities.Entity7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "testBean")
@SessionScoped
public class TestBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    	
    private List<Entity7> entites = new ArrayList<>();
    
    private Entity7 selectedEntity;
    
    private Entity7 entityToAdd;

    public List<Entity7> getEntites() {
        return entites;
    }

    public void setEntites(List<Entity7> entites) {
        this.entites = entites;
    }
    
    public String addEntity() {
	this.entites.add(entityToAdd);
	return "selectEntity";
    }

    public Entity7 getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(Entity7 selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public Entity7 getEntityToAdd() {
        return entityToAdd;
    }

    public void setEntityToAdd(Entity7 entityToAdd) {
        this.entityToAdd = entityToAdd;
    }
    
}
