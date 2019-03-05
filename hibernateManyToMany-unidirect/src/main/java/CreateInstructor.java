import demo.Student;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructor {

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

            session.beginTransaction();

            int instructorID = 3;

            Instructor instructor = session.get(Instructor.class,instructorID);

            Course course = new Course("Udzielanie lekcji aktorstwa");

            instructor.add(course);

            session.save(course);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
