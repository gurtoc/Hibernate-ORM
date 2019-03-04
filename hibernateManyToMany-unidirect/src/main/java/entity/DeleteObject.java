package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObject {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int instructorID = 2;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,2);

            session.delete(instructor);

            session.getTransaction().commit();



        }finally {
            factory.close();
        }

    }
}
