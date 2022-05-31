package JDBCExperiments.core;

public class Course {
  private int id;
  private String name;
  private int duration;
  private CourseType type;
  private String description;
  private int teacherId;
  private int studentsCount;
  private int price;
  private float pricePerHour;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public CourseType getType() {
    return type;
  }

  public void setType(CourseType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }

  public int getStudentsCount() {
    return studentsCount;
  }

  public void setStudentsCount(int studentsCount) {
    this.studentsCount = studentsCount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public float getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(float pricePerHour) {
    this.pricePerHour = pricePerHour;
  }

  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", duration=" + duration +
        ", type=" + type +
        ", description='" + description + '\'' +
        ", teacherId=" + teacherId +
        ", studentsCount=" + studentsCount +
        ", price=" + price +
        ", pricePerHour=" + pricePerHour +
        '}';
  }
}
