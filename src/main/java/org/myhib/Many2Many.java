package org.myhib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Many2Many {
    @Id
    private int id;
    private String emp_name;
    private String emp_phone;
    //OneToMany
    @OneToMany(mappedBy = "many2Many")
    private List<Address> address;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Many2Many{" +
                "address=" + address +
                ", id=" + id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                '}';
    }
}
