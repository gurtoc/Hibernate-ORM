import demo.Student;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDetail {
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

            int instructorID = 1;

            Instructor instructor = session.get(Instructor.class,instructorID);

            InstructorDetail instructorDetail = new InstructorDetail("snake.youtube.com","spying");

            instructor.setInstructorDetailId(instructorDetail);

            session.getTransaction().commit();


        }finally {
            session.close();
            factory.close();
        }
    }
}
