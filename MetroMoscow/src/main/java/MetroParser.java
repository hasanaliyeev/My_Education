import core.Line;
import core.Station;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MetroParser {

  private Document doc;
  private JSONObject jsonObject;
  private Line line;

  public MetroParser(String URL) {
    try {
      doc = Jsoup.connect(URL).maxBodySize(0).get();
      jsonObject = new JSONObject();
      line = new Line();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Document getDoc() {
    return doc;
  }

  public void addLines() {
    JSONArray jsonArray = new JSONArray();

    Elements elements = doc.select("span.js-metro-line");
    elements.forEach(element -> {
      String number = element.attr("data-line");
      String name = element.text();
      Line line = new Line();
      line.setNumber(number);
      line.setName(name);
      JSONObject object = new JSONObject();
      object.put("number", line.getNumber());
      object.put("name", line.getName());
      jsonArray.add(object);
    });
    jsonObject.put("lines", jsonArray);
  }

  public void addConnections() {
    JSONArray connectionArray = new JSONArray();

    Elements metroStationsElements = doc.select("div.js-metro-stations");

    metroStationsElements.forEach(element -> {

      String line = element.attr("data-line");

      Elements classElement = element.select("p");
      classElement.forEach(elm -> {
        Elements elementsSpan = elm.select("span.t-icon-metroln");
        if (elementsSpan.hasAttr("title")) {
          JSONArray connArray = new JSONArray();

          JSONObject map = new JSONObject();

          String station = elm.select("span.name").text();

          map.put("line", line);
          map.put("station", station);
          connArray.add(map);

          Elements titleElements = elm.select("span.t-icon-metroln");
          titleElements.forEach(x -> {
            JSONObject connectMap = new JSONObject();
            String connectLine = x.className().substring(x.className().indexOf("ln-"))
                .replaceAll("[ln-]+", "");
            String connectStation = x.attr("title")
                .substring(x.attr("title").indexOf("«"), x.attr("title").indexOf("»"))
                .replaceAll("[«»]+", "");
            connectMap.put("line", connectLine);
            connectMap.put("station", connectStation);
            connArray.add(connectMap);
          });

          System.out.println(connArray);
          connectionArray.add(connArray);
        }

      });


    });
    jsonObject.put("connections", connectionArray);

  }

  public void addStations() {
    JSONObject stationObject = new JSONObject();

    Elements elements = doc.select("div.js-metro-stations");
    elements.forEach(element -> {
      String lineNumber = element.attr("data-line");
      line.setNumber(lineNumber);
      Elements stationElements = element.select("span.name");

      List<String> stationList = new ArrayList<>();
      stationElements.forEach(stationElement -> {
        Station station = new Station(stationElement.text(), line);
        stationList.add(station.getName());
        line.addStation(station);
      });
      stationObject.put(line.getNumber(), stationList);
    });
    jsonObject.put("stations", stationObject);
  }


  public void writeJsonFile(String path) {
    addStations();
    addLines();
    addConnections();
    try (FileWriter fileWriter = new FileWriter(path)) {
      fileWriter.write(jsonObject.toJSONString());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
