package org.retrieve.many;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.insert.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> s1 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        // To get multiple data we go for HQL(Hibernate Query Language)
        s1 = s.createQuery("from Student", Student.class).list();

        s.close();
        sf.close();
        System.out.println(s1);
    }
}
