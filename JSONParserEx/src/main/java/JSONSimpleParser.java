import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONSimpleParser {

  public Root parse() {
    Root root = new Root();

    JSONParser parser = new JSONParser();

    try (FileReader reader = new FileReader("data/map.json");) {

      JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

      JSONObject stations = (JSONObject) rootJsonObject.get("stations");
      JSONArray lines = (JSONArray) rootJsonObject.get("lines");

      for (Object it : lines) {
        JSONObject lineJsonObject = (JSONObject) it;
        String lineNumber = (String) lineJsonObject.get("number");
        String lineName = (String) lineJsonObject.get("name");
        Line line = new Line(lineName, lineNumber);
        root.addLine(line);
      }

      stations.keySet().forEach(lineNumberObject -> {
        String lineNumber = (String) lineNumberObject;
        Line line = root.getLine(lineNumber);
        JSONArray stationsArray = (JSONArray) stations.get(lineNumberObject);
        stationsArray.forEach(stationObject -> {
          Station station = new Station((String) stationObject, line);
          line.addStation(station);
        });

      });

      return root;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
