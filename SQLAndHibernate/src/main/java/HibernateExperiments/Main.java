package HibernateExperiments;

import HibernateExperiments.core.Student;
import HibernateExperiments.core.Teacher;
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
    Student student = session.get(Student.class,1);
    System.out.println(student.getRegistrationDate());
    System.out.println();

    Teacher teacher = session.get(Teacher.class,7);
    System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getSalary() + " " + teacher.getAge());
    System.out.println();

    sessionFactory.close();

  }

}
