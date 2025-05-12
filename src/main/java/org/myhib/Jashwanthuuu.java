package org.myhib;

import jakarta.persistence.*;

@Entity
//@Table(name="Jashu")
public class Jashwanthuuu {
    @Id
    private int emp_id;
    private String emp_name;
    //@Column(name = "emp_location")
    // It is used for not to store this column in db it is extra info about a employee
    //@Transient
    //private String emp_address;
    private String emp_phone;
    // It is used for one employee has one address only.
    @OneToOne
    private Address a1;

    public Address getA1() {
        return a1;
    }

    public void setA1(Address a1) {
        this.a1 = a1;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    @Override
    public String toString() {
        return "Jashwanthuuu{" +
                "a1=" + a1 +
                ", emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                '}';
    }
}

