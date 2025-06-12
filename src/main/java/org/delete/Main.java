package org.delete;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.insert.Student;
public class Main {
    public static void main(String[] args) {
        Student student1 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure().
                buildSessionFactory();

        Session session = sf.openSession();


        // To delete
        // FIRST we want to get the data by id and it fetch id details and wrote a delete query
        int id = 4;
        student1 = session.get(Student.class, id);
        if(student1 != null) {
            Transaction txn = session.beginTransaction();
            session.remove(student1);
            txn.commit();
            System.out.println("Removed student: " + student1);
        }
        else {
            System.out.println("No student found with id: " + id);
        }
        session.close();
        sf.close();
    }
}
