package info.sigmaproject.jat.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Entity7 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String entityName;

    @Column(nullable = false, unique = true)
    private Integer entityIdentifier;

    public Entity7() {
        super();
    }

    public Entity7(String entityName, Integer entityIdentifier) {
        this.entityName = entityName;
        this.entityIdentifier = entityIdentifier;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getEntityIdentifier() {
        return entityIdentifier;
    }

    public void setEntityIdentifier(Integer entityIdentifier) {
        this.entityIdentifier = entityIdentifier;
    }

    public static boolean validateString(String value) {
        if (!value.startsWith("Entity ")) return false;

        String tmp[] = value.split(" ");
        if (tmp.length != 2) return false;
        String nameId[] = tmp[1].split(":");

        if (nameId.length != 2) return false;

        try {
            Integer.parseInt(nameId[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Entity " + this.getEntityName() + ":" + this.getEntityIdentifier();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Entity7)) return false;

        Entity7 entity = (Entity7) other;

        if (!this.entityName.equals(entity.entityName) || this.entityIdentifier != entity.entityIdentifier)
            return false;

        return true;
    }
}
