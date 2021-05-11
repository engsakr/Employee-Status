package com.workmotion.employee.models;

import com.workmotion.employee.enums.EmployeeState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="Employee")
@Table(name="employees" )
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id" , updatable = false , nullable = false , unique = true)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    @Column(name="status")
    private int state= EmployeeState.ADDED.getAction();

    @Column(name="contract")
    private String contract;

    @Column(name="created")
    @CreationTimestamp
    private Date created;

    @Column(name="updated")
    @UpdateTimestamp
    private Date updated;

    public Employee() {
    }


    public Employee(long id, String name, String email, int age, int state, String contract, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.state = state;
        this.contract = contract;
        this.created = created;
        this.updated = updated;
    }


    public Employee(long id, String name, String email, int age, int state, String contract) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.state = state;
        this.contract = contract;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
