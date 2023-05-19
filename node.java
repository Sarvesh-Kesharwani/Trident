import java.awt.*;
import java.util.*;

public class GraphVisualizer {

    private static final int PADDING = 10;

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        // Create a visual representation of the graph
        GraphVisualizer visualizer = new GraphVisualizer();
        visualizer.visualize(graph);
    }

    private void visualize(Graph graph) {
        // Create a new JFrame
        JFrame frame = new JFrame("Graph Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel to contain the graph
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(graph.getNodeCount(), graph.getNodeCount()));

        // Add nodes to the panel
        for (String node : graph.getNodes()) {
            JLabel label = new JLabel(node);
            panel.add(label);
        }

        // Add edges to the panel
        for (String edge : graph.getEdges()) {
            JLabel label = new JLabel(edge);
            panel.add(label);
        }

        // Set the size of the frame
        frame.setSize(graph.getNodeCount() * PADDING * 2 + PADDING, graph.getNodeCount() * PADDING * 2 + PADDING);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);
    }
}

class Graph {

    private Set<String> nodes;
    private Set<String> edges;

    public Graph() {
        nodes = new HashSet<>();
        edges = new HashSet<>();
    }

    public void addNode(String node) {
        nodes.add(node);
    }

    public void addEdge(String node1, String node2) {
        edges.add(node1 + "-" + node2);
        edges.add(node2 + "-" + node1);
    }

    public Set<String> getNodes() {
        return nodes;
    }

    public Set<String> getEdges() {
        return edges;
    }
}
