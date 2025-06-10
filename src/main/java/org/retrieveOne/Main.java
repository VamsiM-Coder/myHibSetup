package org.retrieveOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.insert.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 =null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();

        //While fetching the data transaction is not important, it is used when you go for manipulation
        // Transaction txn = session.beginTransaction();
         s1 = session.get(Student.class,2);

         session.close();
         sf.close();
         System.out.println(s1);
    }
}