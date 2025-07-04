package org.insert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Student s1 = new Student();
         s1.setId(6);
         s1.setName("Jashwanth");
         s1.setAge(21);

         Student s2 = new Student();
         s2.setId(7);
         s2.setName("Chinni");
         s2.setAge(22);

         // It is not recommended.

         // It is used only once right so we can reduce 3 lines to 1 line it's easier to manage
//         Configuration con = new Configuration();
//         con.addAnnotatedClass(Student.class);
//         con.configure("hibernate.cfg.xml");

         // we want to close manually the resources this may lead resource leak or by try and catch block
         //SessionFactory sf = con.buildSessionFactory(); // It is a heavy weight object it is only used once

         SessionFactory sf = new Configuration()
                 .addAnnotatedClass(Student.class)
                 .configure().
                 buildSessionFactory();

         Session session = sf.openSession();

         // It says save method is depreciated from hibernate 6.0  show we can use persist
         // It is older version method.s
         //session.save(student1);


         Transaction txn = session.beginTransaction();
         session.persist(s1);
         session.persist(s2); //Insert data.
         txn.commit();

         session.close();
         sf.close();
         System.out.println(s1);
         System.out.println(s2);
    }
}