package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import minheap.*;

public class Graph<T, V>{

  protected HashMap<T, HashMap<T, V>> graph;
  protected boolean oriented;
  protected Comparator<T> tComparator;

  /**
   * Constructor for the class Graph
   * @param oriented    if it's true the graph is oriented,
   *                    not oriented in the other case
   * @param tComparator the comparator for the Graph
   */
  public Graph(boolean oriented, Comparator<T> tComparator){
    this.graph = new HashMap<T, HashMap<T, V>>();
    this.oriented = oriented;
    this.tComparator = tComparator;
  }

  /**
  * @return true if the Graph is empty, false in the other case
  */
  public boolean isEmpty(){
    return graph.isEmpty();
  }

  /**
   * insert new vertex in the graph
   * @param vertex the key of the vertex endVertex insert
   */
  public void insertVertex(T vertex) throws GraphException{
    if(graph.containsKey(vertex))
      throw new GraphException("Vertex " + vertex + " already exist.");

    if(!graph.containsKey(vertex))
      graph.put(vertex, null);
  }

  /**
   * Insert a new edge in the graph
   * @param  startVertex    the first vertex
   * @param  endVertex      the second vertex
   * @param  label          the label of the edge, can be a weight
   * @param  addedOpposite  used for the not oriented Graph
   * @throws GraphException
   */
  public void insertEdge(T startVertex, T endVertex, V label, Boolean addedOpposite) throws GraphException{
    HashMap<T, V> edgesAdjacents = new HashMap<T, V>();

    if(!graph.containsKey(startVertex))
      throw new GraphException("Vertex " + startVertex + " not exist.");

    if(!graph.containsKey(endVertex))
      throw new GraphException("Vertex " + endVertex + " not exist.");

    if(graph.containsKey(startVertex) && graph.get(startVertex) != null)
      edgesAdjacents = graph.get(startVertex);

    if(edgesAdjacents.containsKey(endVertex))
      throw new GraphException("Edge " + startVertex + "-->" + endVertex + " already exist.");

    edgesAdjacents.put(endVertex, label);

    graph.put(startVertex, edgesAdjacents);

    if(!oriented && !addedOpposite)
      insertEdge(endVertex, startVertex, label, true);
  }

  /**
   * Remove a vertex
   * @param  vertex         the vertex to remove
   * @throws GraphException
   */
  public void removeVertex(T vertex) throws GraphException{
    HashMap<T, V> edgesAdjacents;

    if(graph.containsKey(vertex))
      graph.remove(vertex);
    else
      throw new GraphException("Vertex " + vertex + " not found");

    for (Map.Entry<T, HashMap<T, V>> entry : graph.entrySet()) {
      edgesAdjacents = entry.getValue();

      if(edgesAdjacents != null)
        for (Map.Entry<T, V> entryAdj : edgesAdjacents.entrySet())
          if(entryAdj.getKey().equals(vertex))
            graph.get(entry.getKey()).remove(vertex);
    }
  }


  /**
   * Remove a new edge in the graph
   * @param  startVertex    the first vertex
   * @param  endVertex      the second vertex
   * @param  addedOpposite  used for the not oriented Graph
   * @throws GraphException
   */
  public void removeEdge(T startVertex, T endVertex, Boolean removedOpposite) throws GraphException{
    HashMap<T, V> startVertexAdj = graph.get(startVertex);

    if(startVertexAdj.containsKey(endVertex))
      startVertexAdj.remove(endVertex);
    else
      throw new GraphException("Edge " + startVertex + "-->" + endVertex + " not found");

    if(!oriented && !removedOpposite)
      removeEdge(endVertex, startVertex, true);
  }

  /**
   * Get all the adjacents of a Key
   * @param      key
   * @return     an HashMap with all the adjacent
   */
  public HashMap<T, V> getAdjacents(T key){
    for(Map.Entry<T, HashMap<T, V>> entry : graph.entrySet())
      if(tComparator.compare(entry.getKey(), key) == 0)
        return entry.getValue();

    return null;
  }

  /**
   * Check if there's the given Key int he graph
   * @param  key
   * @return true if there's the key in the graph, or false
   */
  public boolean containsVertex(T key){
    return graph.containsKey(key);
  }

  /**
   * Check if there's the edge from startVertex to endVertex in the graph
   * @param  startVertex
   * @param  endVertex
   * @return True if there's the edge, or false
   */
  public boolean containsEdge(T startVertex, T endVertex){
    if(graph.containsKey(startVertex))
      if(graph.get(startVertex) != null && graph.get(startVertex).containsKey(endVertex))
        return true;

    return false;
  }

  /**
   * Print the graph
   */
  public void printMap(){
    HashMap<T, V> edgesAdjacents;

    for (Map.Entry<T, HashMap<T, V>> entry : graph.entrySet()){
      edgesAdjacents = entry.getValue();
      for (Map.Entry<T, V> entryAdj : edgesAdjacents.entrySet())
        System.out.println("\t" + entryAdj.getValue() + "\t[" + entry.getKey() + "] --> [" + entryAdj.getKey() + "]");
    }
  }

  /**
   * @return the number of vertex
   */
  public int countVertex(){
    return graph.size();
  }

  /**
   * @return the number of edge
   */
  public int countEdge(){
    int count = 0;
    for (Map.Entry<T, HashMap<T, V>> entry : graph.entrySet())
      if(entry.getValue() != null)
        count = count + entry.getValue().size();

    return oriented ? count : count/2;
  }
}
