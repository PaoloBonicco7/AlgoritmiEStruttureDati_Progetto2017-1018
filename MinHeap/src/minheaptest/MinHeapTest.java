package minheaptest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import minheap.*;

public class MinHeapTest{
  private MinHeap<String,Integer> q;
  Element<String, Integer> el1;
  Element<String, Integer> el2;
  Element<String, Integer> el3;
  Element<String, Integer> el4;

  @Before
  public void creareMinHeap(){
    el1 = new Element<String, Integer>("tests", 4);
    el2 = new Element<String, Integer>("test", 2);
    el3 = new Element<String, Integer>("element", 3);
    el4 = new Element<String, Integer>("heap", 5);
    q = new MinHeap<String, Integer>(new StringComparator(), new IntegerComparator());

    q.insert(el1);
    q.insert(el2);
    q.insert(el3);
  }

  @Test
  public void testIsEmpty(){
    assertFalse(q.isEmpty());
  }

  @Test
  public void testInsert() throws MinHeapException{
    q.insert(el4);
    assertEquals(q.getElementAt(3).getValue(), "heap");
  }

  @Test
  public void testMinimum() throws MinHeapException{
    assertEquals(q.minimum().getValue(), "test");
  }

  @Test
  public void TestExtractMin() throws MinHeapException{
    Element<String, Integer> min = q.minimum();
    assertEquals(min, q.extractMin());
  }

  @Test
  public void TestDecreaseKey() throws MinHeapException{
    q.decreaseKey(2, 0);
    assertTrue(q.minimum().getValue().equals("tests") || q.minimum().getValue().equals("element"));
  }

  @Test
  public void TestIncreaseKey() throws MinHeapException{
    q.increaseKey(1, 10);
    assertTrue(q.getElementAt(2).getValue().equals("tests") || q.getElementAt(2).getValue().equals("element"));
  }

}
