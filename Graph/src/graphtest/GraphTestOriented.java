package graphtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import graph.Graph;
import graph.GraphException;
import minheap.*;

public class GraphTestOriented{
  private Graph<String,String> graph;

  @Before
  public void createGraph() throws GraphException{
    graph = new Graph<String,String>(true, new StringComparator());
  }

  @Test
  public void testIsEmpty(){
    assertTrue(graph.isEmpty());
  }

  @Test
  public void testCreateEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", "f", false);
    assertTrue(graph.containsEdge("A", "B"));
  }

  @Test
  public void testCountVertexEmpty() throws GraphException{
    assertTrue(graph.countVertex() == 0);
    graph.insertVertex("F");
    assertTrue(graph.countVertex() == 1);
  }

  @Test
  public void testCountVertex() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    assertTrue(graph.countVertex() == 3);
    graph.insertVertex("F");
    assertTrue(graph.countVertex() == 4);
  }

  @Test
  public void testRemoveVertex() throws GraphException{
    graph.insertVertex("A");
    assertTrue(graph.containsVertex("A"));
    graph.removeVertex("A");
    assert(graph.containsVertex("A"));
  }

  @Test
  public void TestCountEdgeEmpty() throws GraphException{
    assertTrue(graph.countEdge() == 0);
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", "a", false);
    assertTrue(graph.countEdge() == 1);
  }

  @Test
  public void TestCountEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertEdge("A", "B", "a", false);
    graph.insertEdge("C", "B", "b", false);
    assertTrue(graph.countEdge() == 2);
    graph.insertVertex("F");
    graph.insertEdge("A", "F", "f", false);
    assertTrue(graph.countEdge() == 3);
  }

  @Test
  public void TestRemoveEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", "c", false);
    assertTrue(graph.containsEdge("A", "B"));
    graph.removeEdge("A", "B", false);
    assertFalse(graph.containsEdge("A", "B"));
  }
}
