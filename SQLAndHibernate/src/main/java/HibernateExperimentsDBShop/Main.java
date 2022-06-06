package HibernateExperimentsDBShop;

import HibernateExperimentsDBShop.core.Key;
import HibernateExperimentsDBShop.core.Order2good;
import HibernateExperimentsDBShop.core.User;
import jakarta.persistence.Query;
import java.util.concurrent.atomic.AtomicInteger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(
        "hibernateshop.cfg.xml").build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
        .buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    User user = session.get(User.class, 17);

    AtomicInteger totalCount = new AtomicInteger();
    user.getOrders().forEach(order -> {
      System.out.println("Order id: " + order.getId());
      System.out.println("Order date: " + order.getCreationDate());
      order.getGoods().forEach(good -> {
        Order2good order2good = session.get(Order2good.class, new Key(order.getId(), good.getId()));
        int goodId = good.getId();
        String goodName = good.getName();
        int count = order2good.getCount();

        System.out.println("Good ID: " + goodId);
        System.out.println("Good name: " + goodName);
        System.out.println("Count: " + count);
        totalCount.addAndGet(order2good.getCount());
      });

    });

    System.out.println(totalCount);

    transaction.commit();
    sessionFactory.close();


  }

}
