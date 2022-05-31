package JsonEx;

import java.awt.TextComponent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonEx1 {

  public static final String PATH = "src/main/resources/person.json";

  public static void main(String[] args) {

    PersonWriter personWriter = new PersonWriter();
    personWriter.addTeacher(new Teacher("Gasan", 30, 60000));
    personWriter.addTeacher(new Teacher("Farid", 27, 45000));
    personWriter.addTeacher(new Teacher("Gyunel", 30, 38000));
    personWriter.addTeacher(new Teacher("Jhon", 43, 65000));

    personWriter.addStudent(new Student("Murad", 14, "7"));
    personWriter.addStudent(new Student("Alsu", 3, "1"));
    personWriter.addStudent(new Student("Zahra", 21, "8"));
    personWriter.addStudent(new Student("Elnur", 18, "9"));

    PersonReader personReader = new PersonReader();
    personReader.getTeachers().forEach(System.out::println);

  }


}

class PersonReader {

  private List<Teacher> teacherList = new ArrayList<>();

  private JSONParser parser = new JSONParser();

  public PersonReader() {

  }

  public List<Teacher> getTeachers() {
    JSONArray teachers = (JSONArray) getRoot().get("teachers");

    teachers.forEach(th -> {
      JSONObject object = (JSONObject) th;

      String name = (String) object.get("name");
      Long age = (Long) object.get("age");
      Double salary = (Double) object.get("salary");

      Teacher teacher = new Teacher(name, age, salary);
      teacherList.add(teacher);
    });
    return teacherList;
  }

  public JSONObject getRoot() {
    try (FileReader reader = new FileReader("src/main/resources/person.json")) {
      JSONObject object = (JSONObject) parser.parse(reader);
      return object;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}


class PersonWriter {

  private JSONObject root;

  private List<Teacher> teacherList;
  private List<Student> studentList;


  public PersonWriter() {
    root = new JSONObject();
    teacherList = new ArrayList<>();
    studentList = new ArrayList<>();
  }

  public void addTeacher(Teacher teacher) {
    teacherList.add(teacher);
  }

  public void addStudent(Student student) {
    studentList.add(student);
  }

  public List<Teacher> getTeacherList() {
    return teacherList;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  private void addPerson() {
    JSONArray teacherArray = new JSONArray();
    JSONArray studentArray = new JSONArray();

    teacherList.forEach(teacher -> {
      JSONObject object = new JSONObject();
      object.put("name", teacher.getName());
      object.put("age", teacher.getAge());
      object.put("salary", teacher.getSalary());
      teacherArray.add(object);
    });

    studentList.forEach(student -> {
      JSONObject object = new JSONObject();
      object.put("name", student.getName());
      object.put("age", student.getAge());
      object.put("course", student.getCourse());
      studentArray.add(object);
    });
    root.put("teachers", teacherArray);
    root.put("students", studentArray);

  }

  public void writeFile(String path) {
    addPerson();
    try (FileWriter fileWriter = new FileWriter(path)) {
      fileWriter.write(root.toJSONString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


class Teacher {

  private String name;
  private long age;
  private double salary;

  public Teacher(String name, long age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public long getAge() {
    return age;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}


class Student {

  private String name;
  private long age;
  private String course;

  public Student(String name, long age, String course) {
    this.name = name;
    this.age = age;
    this.course = course;
  }

  public String getName() {
    return name;
  }

  public long getAge() {
    return age;
  }

  public String getCourse() {
    return course;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", course='" + course + '\'' +
        '}';
  }
}

class Test {

  public static void main(String[] args) throws Exception {

    String str = "INSERT INTO `good` (`category_id`,`name`,`count`,`price`) VALUES";
    StringBuilder insertBuilder = new StringBuilder();
    insertBuilder.append(str);
    for (int i = 0; i < 100000; i++) {
      int cat = 4;
      String g = "good-" + i;
      String good = "'" + g + "'";
      int count = 1 + i;
      int price = 10 + i;
      StringBuilder builder = new StringBuilder();
      builder.append(cat).append(", ").append(good).append(", ").append(count).append(", ")
          .append(price);
      String fin = "(" + builder + ")";
      insertBuilder.append(fin).append(", ");

    }

    String finalStr = insertBuilder.toString();
    int lastIndex = finalStr.length() - 2;
    String wr = finalStr.substring(0, lastIndex);
    Files.write(Paths.get("src/main/resources/reg.txt"),wr.getBytes());

  }
}