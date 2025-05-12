package org.myhib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {

        Address add1 = new Address();
        add1.setLid(1);
        add1.setStreet("Bairagapateeda");
        add1.setCity("Tirupati");
        add1.setPincode(517501);
        add1.setState("Andhra Pradesh");


        Address add2 = new Address();
        add2.setLid(2);
        add2.setStreet("Madiwala");
        add2.setCity("Banglore");
        add2.setPincode(560068);
        add2.setState("Karnataka");


        //one2one
//       Jashwanthuuu thuu1 = new Jashwanthuuu();
//       thuu1.setEmp_id(101);
//       thuu1.setEmp_name("Dedee");
//       thuu1.setEmp_phone("9915331135");
//       thuu1.setA1(add);

        //one2Many
        Many2Many many1 = new Many2Many();
        many1.setId(102);
        many1.setEmp_name("Jashwanth Kumar");
        many1.setEmp_phone("8688751909");
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Jashwanthuuu.class)
                .addAnnotatedClass(Address.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        Transaction txn = session.beginTransaction();
        session.persist(add);
        session.persist(thuu1);
        txn.commit();

        // After embedded the some fields to data to print this
        Jashwanthuuu j1 = session.get(Jashwanthuuu.class, 1);
        // We are retriving the info but hibernate write insert query inspite of select what is the problem ???
        //Next Class
        System.out.println(j1);

        session.close();
        sf.close();
    }
}
