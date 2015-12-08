package info.sigmaproject.jat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

    private static final long serialVersionUID = 4224547150367475577L;
    
    @Column(nullable = false)
    protected Integer hourlyWage;
    public Integer getHourlyWage() {
        return hourlyWage;
    }
    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    public PartTimeEmployee() {
	super();
	// TODO Auto-generated constructor stub
    }
}
