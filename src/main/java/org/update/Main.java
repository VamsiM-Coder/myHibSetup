package org.update;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.insert.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();



        //While fetching the data transaction is not important, it is used when you go for manipulation
        // Transaction txn = session.beginTransaction();
        Student student2 = session.get(Student.class,46);

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
