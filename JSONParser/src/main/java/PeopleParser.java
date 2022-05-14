import core.Student;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PeopleParser {

  public PeopleParser(){

  }

  public JSONObject getRoot(){
    try (FileReader reader = new FileReader("src/main/resources/person.json")) {
      JSONParser parser = new JSONParser();
      JSONObject rootObject = (JSONObject) parser.parse(reader);
      return rootObject;
    } catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public void studentParse(){
    JSONArray jsonArray = (JSONArray) getRoot().get("students");
    jsonArray.forEach(element-> {
      JSONObject object = (JSONObject) element;
      long id = (long) object.get("id");
      String name = (String) object.get("name");
      long age = (long) object.get("age");
      Student student = new Student(id,name,age);
    });

  }

}
