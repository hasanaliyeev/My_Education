package HibernateExperiments;

import HibernateExperiments.core.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.buildSessionFactory();

    Session session = sessionFactory.openSession();

    String hql = "From " + Course.class.getSimpleName() + " Where studentsCount > 100 and studentsCount < 300";

    List<Course> courses = session.createQuery(hql).list();
    courses.forEach(course -> System.out.println(course.getId() + " " + course.getName() +
        " " + course.getPrice() + " " + course.getStudentsCount()));

    sessionFactory.close();

  }

}
