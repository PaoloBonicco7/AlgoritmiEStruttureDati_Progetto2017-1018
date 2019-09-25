package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import minheap.*;

public class Prim<T>{

  private WeightGraph<T> graph;
  private Comparator<Double> doubleComparator;

  /**
   * Constructor for Prim
   * @param graph            the graph to analize
   * @param doubleComparator comparator for the graph
   */
  public Prim(WeightGraph<T> graph, Comparator<Double> doubleComparator){
    this.graph = graph;
    this.doubleComparator = doubleComparator;
  }

  /**
   * Prim Algorithm
   * @param  start          the start vertex
   * @return                The minimum spanning tree
   * @throws GraphException 
   */
  public WeightGraph<T> prim(T start) throws GraphException, MinHeapException{
    MinHeap<T,Double> heapVertices = graph.getVertex();
    WeightGraph<T> resultGraph = new WeightGraph<T>(false, null, null);
    HashMap<T,Double> adj = new HashMap<T,Double>();
    int indexEl;
    T firstVertex = start;

    while(!heapVertices.isEmpty()){
      Element<T,Double> lightestElement = heapVertices.minimum();

      if(doubleComparator.compare(lightestElement.getKey(), Double.MAX_VALUE) == 0)
        heapVertices.decreaseKey(0, 0.0);
      else
        graph.fillGraph(resultGraph, firstVertex, lightestElement.getValue(), lightestElement.getKey());

      heapVertices.extractMin();

      adj = graph.getAdjacents(lightestElement.getValue());

      for(Map.Entry<T,Double> entry : adj.entrySet())
        if((indexEl = heapVertices.containsElement(entry.getKey())) >= 0)
          if(doubleComparator.compare(heapVertices.getElementAt(indexEl).getKey(), entry.getValue()) > 0)
            heapVertices.decreaseKey(indexEl, entry.getValue());

      firstVertex = lightestElement.getValue();
    }
    return resultGraph;
  }

}
