//import javafx.util.Pair;
import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> listInput = new HashMap<>();
    HashMap<Pair<String, Integer>, Pair<Integer, Integer>> averageTime = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair<String, Integer> currTrail = new Pair<>(stationName, t);
        listInput.put(id, currTrail);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int timeIn = listInput.get(id).getValue();
        Pair<String, Integer> currTrail = new Pair(listInput.get(id).getKey(), stationName);

        if (averageTime.containsKey(currTrail)) {
            averageTime.put(currTrail, new Pair<>(averageTime.get(currTrail).getKey() + (t - timeIn),
                                                  averageTime.get(currTrail).getValue() + 1));
        } else {
            averageTime.put(currTrail, new Pair<>(t - timeIn, 1));
        }

        listInput.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> currTrail = new Pair(startStation, endStation);

        if (averageTime.containsKey(currTrail)) {
            return (double) averageTime.get(currTrail).getKey() / averageTime.get(currTrail).getValue();
        } else {
            return 0.0;
        }
    }
}
