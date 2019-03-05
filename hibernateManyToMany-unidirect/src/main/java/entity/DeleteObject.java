package entity;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObject {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int courseID = 12;

            session.beginTransaction();

            // Instructor instructor = session.get(Instructor.class,2);
            Course course = session.get(Course.class, 12);
            session.delete(course);

            session.getTransaction().commit();


        } finally {
            factory.close();
        }

    }
}
