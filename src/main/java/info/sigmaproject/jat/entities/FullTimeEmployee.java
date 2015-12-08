package info.sigmaproject.jat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private static final long serialVersionUID = 947074061819674641L;
    
    @Column(nullable = false)
    protected Integer salary;
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public FullTimeEmployee() {
	super();
	// TODO Auto-generated constructor stub
    }

}
