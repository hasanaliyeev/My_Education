package core;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private String number;
  private String name;
  private List<Station> stations;

  public Line() {
    stations = new ArrayList<>();
  }

  public void addStation(Station station) {
    stations.add(station);
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setName(String name) {
    this.name = name;
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
