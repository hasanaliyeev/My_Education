package HibernateExperiments2;

import HibernateExperiments2.core.Course;
import HibernateExperiments2.core.Student;
import HibernateExperiments2.core.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;
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
//    Transaction transaction = session.beginTransaction();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Course> query = builder.createQuery(Course.class);
    Root<Course> root = query.from(Course.class);

    query.select(root).where(builder.greaterThan(root.get("price"),100000)).orderBy(builder.desc(root.get("price")));

    List<Course> courses = session.createQuery(query).setMaxResults(3).getResultList();
    courses.forEach(course -> {
      System.out.println(course.getName() + " - " + course.getPrice());
    });

//    transaction.commit();
    sessionFactory.close();

  }

}
