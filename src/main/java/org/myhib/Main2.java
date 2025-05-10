package org.myhib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {

        Address add = new Address();
        add.setStreet("AutoNagar");
        add.setCity("Tirupati");
        add.setState("Andhra Pradesh");

       Jashwanthuuu thuu1 = new Jashwanthuuu();
       thuu1.setEmp_id(1);
       thuu1.setEmp_name("Dedee");
       thuu1.setEmp_phone("9915331135");
       thuu1.setA1(add);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Jashwanthuuu.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        Transaction txn = session.beginTransaction();
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
