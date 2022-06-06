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
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_status")
@Setter
@Getter
public class OrderStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "sort_index")
  private int sortIndex;

  private String code;

  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "`order`",
      joinColumns = {@JoinColumn(name = "status_id")},
      inverseJoinColumns = {@JoinColumn(name = "id")}
  )
  private List<Order> orders;

}
