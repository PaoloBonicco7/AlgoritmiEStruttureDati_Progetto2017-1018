package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import minheap.*;

public class WeightGraph<T> extends Graph<T, Double>{

  private Comparator<Double> doubleComparator;

  /**
   * Costructor for a WeightGraph
   * @param oriented         true if graph is oriented, or false
   * @param tComparator      comparator for vertices
   * @param doubleComparator comparator for the weight
   */
  public WeightGraph(boolean oriented, Comparator<T> tComparator, Comparator<Double> doubleComparator){
    super(oriented, tComparator);
    this.doubleComparator = doubleComparator;
  }

  /**
   * @return The graph's weight
   * @throws GraphException
   */
  public double getGraphWeight() throws GraphException{
    HashMap<T, Double> edge;
    double totalWeight = 0;

    for (Map.Entry<T, HashMap<T, Double>> entry : graph.entrySet()) {
      edge = entry.getValue();
      if(edge != null)
        for (Map.Entry<T, Double> entryAdj : edge.entrySet())
          totalWeight = totalWeight + (double)entryAdj.getValue();
    }

    return oriented ? totalWeight : totalWeight/2;
  }

  /**
   * @return A minheap with the vertices of graph
   */
  public MinHeap<T, Double> getVertex(){
    MinHeap<T, Double> heap = new MinHeap<T, Double>(tComparator, doubleComparator);

    for(Map.Entry<T, HashMap<T, Double>> entry : graph.entrySet())
      heap.insert(new Element<T, Double>(entry.getKey(), Double.MAX_VALUE));

    return heap;
  }

  /**
   * add to the graph two vertices startVertex and endVertex and
   * the edge between them
   * @param  graphToFill    graph to fill with two vertices
   * @param  startVertex    first vertex to add
   * @param  endVertex      second vertex to add
   * @param  weight         the weight of the edge between startVertex and endVertex
   * @throws GraphException
   */
  public void fillGraph(WeightGraph<T> graphToFill , T startVertex, T endVertex, Double weight) throws GraphException{
    if(!graphToFill.containsVertex(startVertex))
      graphToFill.insertVertex(startVertex);
    if(!graphToFill.containsVertex(endVertex))
      graphToFill.insertVertex(endVertex);
    if(!graphToFill.containsEdge(startVertex, endVertex))
      graphToFill.insertEdge(startVertex, endVertex, weight, false);
  }

  /**
   * Print the stats of the graph
   * @throws GraphException
   */
  public void printStats() throws GraphException{
    System.out.println("\n\tNumber of vertices: " + countVertex());
    System.out.println("\tNumber of edges: " + countEdge());
    System.out.println("\tMinimum total weight: " + getGraphWeight() + "\n");
  }
}
