import core.Line;
import core.Station;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

public class Main {

  public static void main(String[] args) {

    Map<String, List<String>> stations = new TreeMap<>();
    List<Map<String, String>> lines = new ArrayList<>();
    List<String> connections = new ArrayList<>();

    MetroParser metroParser = new MetroParser("https://skillbox-java.github.io/");
    metroParser.writeJsonFile("src/main/resources/map.json");
    metroParser.addConnections();


    Elements elements = metroParser.getDoc().select("div.js-metro-stations");
    elements.forEach(x -> {

      String lineNumber = x.attr("data-line");

      List<String> list = new ArrayList<>();
      Elements stationElements = x.select("span.name");
      stationElements.forEach(element -> {
        String station = element.text();
        list.add(station);
      });
      stations.put(lineNumber, list);
    });

    Elements lineElements = metroParser.getDoc().select("span.js-metro-line");
    lineElements.forEach(element -> {

      Map<String, String> lineMap = new HashMap<>();
      String numberLine = element.attr("data-line");
      String nameLine = element.text();
      lineMap.put("number", numberLine);
      lineMap.put("name", nameLine);
      lines.add(lineMap);
    });

    Elements connectionElements = metroParser.getDoc().select("p.single-station");
    connectionElements.forEach(x-> {

      if(x.select("span.t-icon-metroln").hasAttr("title")){
        //System.out.println(x);
      }
    });


    connectionElements.forEach(element -> {
      List<Map<String,String>> connectionList = new ArrayList<>();

      String lineNumber = element.attr("data-line");

      Elements stationConnectionElements = element.select("span.t-icon-metroln");

      stationConnectionElements.forEach(element1 -> {

        Map<String, String> map = new HashMap<>();

        String station = element1.parent().select("span.name").text();

        map.put("line", lineNumber);
        map.put("station", station);

        connectionList.add(map);

        String connectStation = element1.attr("title")
            .substring(element1.attr("title").indexOf("«"), element1.attr("title").indexOf("»"))
            .replaceAll("[«»]+", "");
        String connectionStationLine = element1.className()
            .substring(element1.className().indexOf("ln-"))
            .replaceAll("[ln-]+", "");
        map = new HashMap<>();

        map.put("line", connectionStationLine);
        map.put("station", connectStation);
        connectionList.add(map);

      });



    });

    JSONObject jsonObject = new JSONObject();
    //jsonObject.put("stations", stations);
    //jsonObject.put("lines", lines);
    jsonObject.put("connections", connections);


  }


}
