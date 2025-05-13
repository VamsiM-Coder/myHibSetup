package org.myhib;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//without embedded it shows Not determine java type org.myhib.Address so we can solve this by annotate Embeddable
@Entity
public class Address {

    @Id
    private int lid;
    private String street;
    private String city;
    private String state;
    private int pincode;

    // Without 3rd table we can store the result
    @ManyToOne
    private Many2Many many2Many;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Many2Many getMany2Many() {
        return many2Many;
    }

    public void setMany2Many(Many2Many many2Many) {
        this.many2Many = many2Many;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", lid=" + lid +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
