import java.util.ArrayList;
import java.util.List;

public class Line {

  private String name;
  private String number;
  private List<Station> stations;

  public Line(String name, String number) {
    this.name = name;
    this.number = number;
    stations = new ArrayList<>();
  }

  public void addStation(Station station) {
    stations.add(station);
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public List<Station> getStations() {
    return stations;
  }

  public String toString(){
    return name + " " + stations;
  }

}
