import demo.Student;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatObject {
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

            Course course = new Course("Malowanie pejzazy");

            session.save(course);

            Student student1 = new Student("Mariusz","Bagno","bagno@gmail.com");
            Student student2 = new Student("Jakub","Koza","koza@2p.pl");

            course.addStundet(student1);
            course.addStundet(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }

    }
}
