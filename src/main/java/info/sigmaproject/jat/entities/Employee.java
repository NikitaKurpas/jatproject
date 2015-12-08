package info.sigmaproject.jat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public abstract class Employee implements Serializable {

    public Employee() {
	super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer employeeId;
    
}
