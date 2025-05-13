package org.myhib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

        Address add1 = new Address();
        add1.setLid(10);
        add1.setStreet("Raghavendra Nagar");
        add1.setCity("Tirupati");
        add1.setPincode(517501);
        add1.setState("Andhra Pradesh");


        Address add2 = new Address();
        add2.setLid(11);
        add2.setStreet("Madiwala");
        add2.setCity("Banglore");
        add2.setPincode(560068);
        add2.setState("Karnataka");


//        one2one
//       Jashwanthuuu thuu1 = new Jashwanthuuu();
//       thuu1.setEmp_id(101);
//       thuu1.setEmp_name("Dedee");
//       thuu1.setEmp_phone("9915331135");
//       thuu1.setA1(add);
        //one2Many
        Many2Many many1 = new Many2Many();
        many1.setId(103);
        many1.setEmp_name("Vamsi");
        many1.setEmp_phone("8500221235");
        many1.setAddress(Arrays.asList(add1,add2));


        //One2Many and Many2One
        add1.setMany2Many(many1);
        add2.setMany2Many(many1);

        SessionFactory sf = new Configuration()
                //.addAnnotatedClass(Jashwanthuuu.class)
                .addAnnotatedClass(Many2Many.class)
                .addAnnotatedClass(Address.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        Transaction txn = session.beginTransaction();
        session.persist(add1);
        session.persist(add2);
        session.persist(many1);
        txn.commit();

        // After embedded the some fields to data to print this
        //Jashwanthuuu j1 = session.get(Jashwanthuuu.class, 1);
        // We are retriving the info but hibernate write insert query inspite of select what is the problem ???
        //Next Class
        //System.out.println(j1);

        session.close();
        sf.close();
    }
}
