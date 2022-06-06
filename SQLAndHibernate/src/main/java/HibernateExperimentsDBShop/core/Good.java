package HibernateExperimentsDBShop.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "good")
@Setter
@Getter
public class Good {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  private GoodCategory category;

  private String name;

  private int count;

  private int price;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "order2good",
      joinColumns = {@JoinColumn(name = "good_id")},
      inverseJoinColumns = {@JoinColumn(name = "order_id")}
  )
  private List<Order> orders;

}
