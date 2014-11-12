package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer employeeId;
}
