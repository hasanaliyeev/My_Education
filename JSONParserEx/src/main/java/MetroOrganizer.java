import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MetroOrganizer {

  private Document doc;
  private JSONObject jsonObject;

  private Map<String, String> lines;
  private Map<String, List<String>> stations;

  public MetroOrganizer(String url) {
    try {
      doc = Jsoup.connect(url).maxBodySize(0).get();
      jsonObject = new JSONObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void addLines() {
    lines = new HashMap<>();
    Elements elements = doc.select("span.js-metro-line");
    elements.forEach(element -> {
      String lineNumber = element.attr("data-line");
      String lineName = element.text();
      lines.put(lineNumber, lineName);
    });

    JSONArray array = new JSONArray();

    for (Map.Entry<String, String> entry : lines.entrySet()) {
      JSONObject lineObject = new JSONObject();
      lineObject.put("number", entry.getKey());
      lineObject.put("name", entry.getValue());
      array.add(lineObject);
    }
    jsonObject.put("lines", array);
  }

  public void addStations() {
    stations = new HashMap<>();
    Elements elements = doc.select("div.js-metro-stations");
    elements.forEach(element -> {
      List<String> stationList = new ArrayList<>();
      String line = element.attr("data-line");
      Elements stationElement = element.select("span.name");
      for (Element st : stationElement){
        stationList.add(st.text());
      }
      stations.put(line,stationList);
    });
    jsonObject.put("stations",stations);
  }

  public void write(String path){
    try(FileWriter fileWriter = new FileWriter(path)) {
      fileWriter.write(jsonObject.toJSONString());

    } catch (Exception e){
      e.printStackTrace();
    }

  }

}
