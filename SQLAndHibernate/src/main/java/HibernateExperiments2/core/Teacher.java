package HibernateExperiments2.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
public class Teacher {

  @Setter
  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Setter
  @Getter
  private String name;

  @Setter
  @Getter
  private int salary;

  @Setter
  @Getter
  private int age;

  @Setter
  @Getter
  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "courses", joinColumns = {
      @JoinColumn(name = "teacher_id")}, inverseJoinColumns = {@JoinColumn(name = "id")})
  private List<Course> courses;

}
