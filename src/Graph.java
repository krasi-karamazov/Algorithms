import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<Vertex, List<Vertex>> graphData = new HashMap<>();


    class Vertex{
        private String label;

        public Vertex(String label) {
            this.label = label;
        }
    }

    public void addVertex(String value) {
        graphData.putIfAbsent(new Vertex(value), new ArrayList<>());
    }
}
