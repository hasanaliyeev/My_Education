package HibernateExperiments2;

import HibernateExperiments2.core.Course;
import HibernateExperiments2.core.Student;
import HibernateExperiments2.core.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) throws Exception {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(
        "hibernate2.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    Teacher teacher = session.get(Teacher.class,20);
    teacher.getCourses().forEach(x-> System.out.println(x.getName()));

    transaction.commit();
    sessionFactory.close();

  }

}
