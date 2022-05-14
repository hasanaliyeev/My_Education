import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JsonSimple {

  public static void main(String[] args) {

    Staff staff = createStaff();


    String json = Jsoner.serialize(staff);

    json = Jsoner.prettyPrint(json);


    try (FileWriter fileWriter = new FileWriter("src/main/resources/info.json")) {

      Jsoner.serialize(staff, fileWriter);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static Staff createStaff() {

    Staff staff = new Staff();

    staff.setName("Gasan Aliev");
    staff.setAge(30);
    staff.setPosition(new String[]{"Founder", "IT Developer", "Economist"});
    Map<String, BigDecimal> salary = new HashMap<>() {
      {
        put("2010", new BigDecimal(20000));
        put("2017", new BigDecimal(30000));
        put("2022", new BigDecimal(60000));
      }
    };
    staff.setSalary(salary);
    staff.setSkills(Arrays.asList("java", "MySql", "kotlin"));
    return staff;
  }
}

public class Staff implements Jsonable {

  private String name;
  private int age;
  private String[] position;
  private List<String> skills;
  private Map<String, BigDecimal> salary;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String[] getPosition() {
    return position;
  }

  public void setPosition(String[] position) {
    this.position = position;
  }

  public List<String> getSkills() {
    return skills;
  }

  public void setSkills(List<String> skills) {
    this.skills = skills;
  }

  public Map<String, BigDecimal> getSalary() {
    return salary;
  }

  public void setSalary(Map<String, BigDecimal> salary) {
    this.salary = salary;
  }

  @Override
  public String toJson() {
    final StringWriter writable = new StringWriter();
    try {
      this.toJson(writable);
    } catch (final IOException e) {

    }
    return writable.toString();
  }

  @Override
  public void toJson(Writer writer) throws IOException {
    final JsonObject json = new JsonObject();
    json.put("name", this.getName());
    json.put("age", this.getAge());
    json.put("position", this.getPosition());
    json.put("skills", this.getSkills());
    json.put("salary", this.getSalary());
    json.toJson(writer);
  }
}

