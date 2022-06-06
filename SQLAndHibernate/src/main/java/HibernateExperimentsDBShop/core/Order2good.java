package HibernateExperimentsDBShop.core;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order2good")
@Setter
@Getter
public class Order2good {

  @EmbeddedId
  private Key key;

  @Column(name = "order_id",insertable = false,updatable = false)
  private int orderId;

  @Column(name = "good_id",insertable = false,updatable = false)
  private int goodId;

  private int count;

}
