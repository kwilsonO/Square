package square.app.domain.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SquareNumber {

  @Id
  @Column(length = 10, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @Column(length = 10, nullable = false)
  private int number;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
