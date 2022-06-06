package HibernateExperimentsDBShop.core;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Key implements Serializable {

  @Column(name = "order_id")
  private int orderId;

  @Column(name = "good_id")
  private int goodId;

  public Key(){}

  public Key(int orderId, int goodId) {
    this.orderId = orderId;
    this.goodId = goodId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return orderId == key.orderId && goodId == key.goodId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, goodId);
  }
}
