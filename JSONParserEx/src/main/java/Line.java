import java.util.ArrayList;
import java.util.List;

public class Line {

  private String number;
  private String name;
  private List<Station> stations;

  public Line(String number, String name) {
    stations = new ArrayList<>();
    this.number = number;
    this.name = name;
  }

  public void addStation(Station station) {
    stations.add(station);
  }

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public List<Station> getStations() {
    return stations;
  }


}
