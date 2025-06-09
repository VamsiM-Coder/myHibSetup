package org.retrieve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.insert.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {




        // It is used only once right so we can reduce 3 lines to 1 line it's easier to manage
//         Configuration con = new Configuration();
//         con.addAnnotatedClass(Student.class);
//         con.configure("hibernate.cfg.xml");

        // we want to close manually the resources this may lead resource leak or by try and catch block
        //SessionFactory sf = con.buildSessionFactory();           // It is a heavy weight object it is only used once

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        // It says save method is depreciated from hibernate 6.0  show we can use persist
        //session.save(student1);


        //While fetching the data transaction is not important, it is used when you go for manipulation
//        Transaction txn = session.beginTransaction();
//         txn.commit();

        //student2 = session.get(Studentt.class,46);

        //Update
        //Transaction txn = session.beginTransaction();

        // This query first fetch the particular id if it is not found it creates a row otherwise it give updated result
        //session.merge(student1);



        // delete
        // FIRST we want to get the data by id and it fetch id details and wrote a delete query
//        student1 = session.get(Student.class,89);
//        Transaction txn = session.beginTransaction();
//
//        session.remove(student1);
//        txn.commit();
//        session.close();
//        sf.close();
//        System.out.println(student2);
    }
}