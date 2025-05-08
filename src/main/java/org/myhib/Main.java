package org.myhib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
         Studentt student1 = new Studentt();
         student1.setId(38);
         student1.setName("Mahesh");
         student1.setAge(23);

         Studentt student2 = new Studentt();
         student1.setId(43);
         student1.setName("Dedeepya");
         student1.setAge(24);

         Configuration con = new Configuration();
         con.addAnnotatedClass(Studentt.class);
         con.configure("hibernate.cfg.xml");
         SessionFactory sf = con.buildSessionFactory();           // It is a heavy weight object it is only used once
         Session session = sf.openSession();
         session.save(student1);
         session.save(student2);

         Transaction txn = session.beginTransaction();
         txn.commit();
         System.out.println(student1);
    }
}