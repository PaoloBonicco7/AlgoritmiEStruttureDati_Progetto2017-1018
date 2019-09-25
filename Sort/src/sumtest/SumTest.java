package sumtest;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sum.Sum;
import sort.*;

public class SumTest{

    private ArrayList<Long> array;
    private Sort<Long> s = new Sort<Long>(new LongComparator());
    Sum so = new Sum();

    @Before
    public void createArray() throws SortException{
      array = new ArrayList<Long>();
      array.add((long)2);
      array.add((long)1);
      array.add((long)4);
      s.mergeSort(array, 0, array.size()-1);
    }

    @Test
    public void test_true() throws SortException{
      assertTrue(so.sum(array, (long) 5));
      assertTrue(so.sum(array, (long) 3));
      assertTrue(so.sum(array, (long) 6));
    }

    @Test
    public void test_false() throws SortException{
      assertFalse(so.sum(array, (long) 1));
      assertFalse(so.sum(array, (long) 2));
      assertFalse(so.sum(array, (long) 4));
    }

    @Test
    public void test_add() throws SortException{
      assertFalse(so.sum(array, (long) 7));
      array.add((long)3);
      s.mergeSort(array, 0, array.size()-1);
      assertTrue(so.sum(array, (long) 7));
    }

    @Test
    public void test_remove() throws SortException{
      assertTrue(so.sum(array, (long) 5));
      array.remove(array.get(array.size()-1));
      assertFalse(so.sum(array, (long) 5));
    }

}
