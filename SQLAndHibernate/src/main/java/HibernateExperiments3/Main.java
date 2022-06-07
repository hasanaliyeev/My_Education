package HibernateExperiments3;

import HibernateExperiments3.core.Department;
import HibernateExperiments3.core.Employee;
import jakarta.persistence.OrderBy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Predicate.BooleanOperator;
import jakarta.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

  public static void main(String[] args) {

    Session session = null;
    Transaction transaction = null;

    try {

      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();

      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Department> query = builder.createQuery(Department.class);
      Root<Department> root = query.from(Department.class);
      query.select(root);

      List<Department> departments = session.createQuery(query).getResultList();
      departments.stream().map(Department::getName).forEach(System.out::println);

      transaction.commit();
    } catch (Exception e) {

    } finally {
      if (session != null) {
        session.close();
      }
    }

    HibernateUtil.shutDown();

  }

}
