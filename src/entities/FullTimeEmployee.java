package entities;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private static final long serialVersionUID = 947074061819674641L;
    protected Integer salary;

}
