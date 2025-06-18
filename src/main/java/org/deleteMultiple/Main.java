package org.deleteMultiple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.insert.Student;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student stud1 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();


        // To delete mutiple rows
        // FIRST we want to get the data by id and it fetch id details and wrote a delete query
        // If id is not present, we unable to delete the data in table.
        List<Integer> idsToDelete = Arrays.asList(2, 3);

        for (Integer id : idsToDelete) {
            Student s = session.get(Student.class, id);
            if (s != null) {
                Transaction txn = session.beginTransaction();
                session.remove(s);
                txn.commit();
            }
        }
        session.close();
        sf.close();
    }
}
