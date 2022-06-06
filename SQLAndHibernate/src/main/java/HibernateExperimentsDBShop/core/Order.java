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
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`order`")
@Setter
@Getter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  private User user;

  @ManyToOne(cascade = CascadeType.ALL)
  private OrderStatus status;

  @Column(name = "creation_date")
  private Date creationDate;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "order2good",
      joinColumns = {@JoinColumn(name = "order_id")},
      inverseJoinColumns = {@JoinColumn(name = "good_id")}
  )
  private List<Good> goods;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "order_status_change",
      joinColumns = {@JoinColumn(name = "`order_id`")},
      inverseJoinColumns = {@JoinColumn(name = "id")}
  )
  private List<OrderStatusChange> statusChanges;


}
