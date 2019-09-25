package graphtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import graph.WeightGraph;
import graph.GraphException;
import minheap.*;

public class WeightGraphTestNotOriented{
  private WeightGraph<String> graph;

  @Before
  public void createGraph() throws GraphException{
    graph = new WeightGraph<String>(false, new StringComparator(), new DoubleComparator());
  }

  @Test
  public void testIsEmpty(){
    assertTrue(graph.isEmpty());
  }

  @Test
  public void testCreateEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", 10.0, false);
    assertTrue(graph.containsEdge("A", "B"));
    assertTrue(graph.containsEdge("B", "A"));
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
    assertFalse(graph.containsVertex("A"));
  }

  @Test
  public void TestCountEdgeEmpty() throws GraphException{
    assertTrue(graph.countEdge() == 0);
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", 10.0, false);
    assertTrue(graph.countEdge() == 1);
  }

  @Test
  public void TestCountEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertEdge("A", "B", 10.0, false);
    graph.insertEdge("C", "B", 30.0, false);
    assertTrue(graph.countEdge() == 2);
    graph.insertVertex("F");
    graph.insertEdge("A", "F", 20.0, false);
    assertTrue(graph.countEdge() == 3);
  }

  @Test
  public void TestRemoveEdge() throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertEdge("A", "B", 10.0, false);
    assertTrue(graph.containsEdge("A", "B"));
    graph.removeEdge("A", "B", false);
    assertFalse(graph.containsEdge("A", "B"));
  }

  @Test
  public void TestGetGraphWeightEmpty() throws GraphException{
    assertTrue(graph.getGraphWeight() == 0);
  }

  @Test
  public void TestGetGraphWeight()throws GraphException{
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertEdge("A", "B", 10.0, false);
    graph.insertEdge("B", "C", 30.0, false);
    assertTrue(graph.getGraphWeight() == 40);
  }
}
