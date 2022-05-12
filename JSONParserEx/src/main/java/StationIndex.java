import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StationIndex {

  Map<String, Line> lines;
  Map<String, List<Station>> stationn;
  List<Station> stations;

  public StationIndex() {
    lines = new HashMap<>();
    stations = new ArrayList<>();
    stationn = new HashMap<>();
  }

  public void parseLine(JSONObject jsonObject) {
    JSONArray lineArray = (JSONArray) jsonObject.get("lines");
    lineArray.forEach(x -> {
      JSONObject object = (JSONObject) x;
      Line line = new Line(object.get("number").toString(), object.get("name").toString());
      lines.put(line.getNumber(), line);
    });

  }

  public void parseStation(JSONObject jsonObject) {
    JSONObject stationObject = (JSONObject) jsonObject.get("stations");
    stationObject.keySet().forEach(lineNumberObject -> {

      String lineNumber = (String) lineNumberObject;
      Line line = getLine(lineNumber);
      JSONArray stationArray = (JSONArray) jsonObject.get(lineNumberObject);
      stationArray.forEach(t -> {
        Station station = new Station((String) t, line);
        stations.add(station);
        line.addStation(station);
      });
      System.out.println(stations);
    });


  }

  public Line getLine(String number) {
    return lines.get(number);
  }

}
