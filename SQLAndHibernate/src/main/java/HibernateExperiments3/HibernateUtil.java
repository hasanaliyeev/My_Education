package HibernateExperiments3;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.configure("hibernate3.cfg.xml");
        registry = registryBuilder.build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch (Exception e) {
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }

  public static void shutDown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

}
