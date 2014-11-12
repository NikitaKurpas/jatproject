package entities;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

    private static final long serialVersionUID = 4224547150367475577L;
    protected Integer hourlyWage;
}
