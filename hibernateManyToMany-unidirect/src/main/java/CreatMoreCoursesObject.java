import demo.Student;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatMoreCoursesObject {
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

            int studentID = 2;

            Student student = session.get(Student.class,studentID);

            Course course = new Course("Zbieranie znaczkow");
            Course course1 = new Course("Gotowanie");
            Course course2 = new Course("Majsterkowanie");

            course.addStundet(student);
            course1.addStundet(student);
            course2.addStundet(student);

            session.save(course);
            session.save(course1);
            session.save(course2);


            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }

    }
}
