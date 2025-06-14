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
        Student s1 = new Student();
        s1.setId(5);
        s1.setName("Vamsi");
        s1.setAge(21);

        Student s2 = new Student();
        s1.setId(4);
        s1.setName("Dedee");
        s1.setAge(22);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();


        Transaction txn = session.beginTransaction();

        // This query first fetch the particular id if it is not found it creates a new row with 0 id otherwise it give updated result
        session.merge(s1);
       // session.merge(s2);
        txn.commit();
        session.close();
        sf.close();
        System.out.println(s1);
        System.out.println(s2);
    }
}
