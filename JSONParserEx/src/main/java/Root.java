import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Root {

  private Map<String, Line> lineMap;


  public Root() {
    lineMap = new HashMap<>();

  }

  public void addLine(Line line) {
    lineMap.put(line.getNumber(), line);
  }


  public Map<String, Line> getLine() {
    return lineMap;
  }

  public Line getLine(String number) {
    return lineMap.get(number);
  }

  public List<Line> getLines() {
    List<Line> ln = new ArrayList<>();
    lineMap.entrySet().forEach(x -> {
      ln.add(x.getValue());
    });
    return ln;
  }


  public void printLineInfo() {
    System.out.println("ЛИНИИ И СТАНЦИИ МОСКОВСКОГО МЕТРО\n");
    lineMap.entrySet().forEach(lineMap -> {
      System.out.println(
          lineMap.getValue().getName() + " - (номер линия) " + lineMap.getValue().getNumber());
      System.out.println("Количество станций: " + lineMap.getValue().getStations().size());
      System.out.println("Список станции: " + lineMap.getValue().getStations());
      System.out.println();

    });

  }

}
