package sorttest;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sort.*;

public class SortTests {

    private Integer el1, el2, el3;
    private ArrayList<Integer> array;
    Sort<Integer> so = new Sort<Integer>(new IntegerComparator());

    @Before
    public void createArray(){
        el1 = -12;
        el2 = 0;
        el3 = 4;
        array = new ArrayList<Integer>();
    }

    @Test
    public void testIsEmpty_zeroEl_MergeSort() throws SortException{
        so.mergeSort(array, 0, array.size()-1);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testIsEmpty_oneEl_MergeSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertFalse(array.isEmpty());
    }

    @Test
    public void testSize_zeroEl_MergeSort() throws SortException{
      so.mergeSort(array, 0, array.size()-1);
      assertEquals(0,array.size());
    }

    @Test
    public void testSize_oneEl_MergeSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertEquals(1,array.size());
    }

    @Test
    public void testSize_twoEl_MergeSort() throws SortException{
        array.add(el1);
        array.add(el2);
        so.mergeSort(array, 0, array.size()-1);;
        assertEquals(2,array.size());
    }


    @Test
    public void testAddGet_oneEl_MergeSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertTrue(el1==array.get(0));
    }

    @Test
    public void testArray_threeEl_MergeSort() throws SortException{

        array.add(el2);
        array.add(el1);
        array.add(el3);
        so.mergeSort(array, 0, array.size()-1);
        Integer[] arrExpected = {el1, el2, el3};

        Integer[] arrActual = new Integer[3];
        for (int i=0; i<3; i++)
            arrActual[i] = array.get(i);

        assertArrayEquals(arrActual,arrExpected);
    }

    @Test
    public void testIsEmpty_zeroEl_InsertioSort() throws SortException{
        so.mergeSort(array, 0, array.size()-1);
        assertTrue(array.isEmpty());
    }

    @Test
    public void testIsEmpty_oneEl_InsertioSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertFalse(array.isEmpty());
    }

    @Test
    public void testSize_zeroEl_InsertioSort() throws SortException{
      so.mergeSort(array, 0, array.size()-1);
      assertEquals(0,array.size());
    }

    @Test
    public void testSize_oneEl_InsertioSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertEquals(1,array.size());
    }

    @Test
    public void testSize_twoEl_InsertioSort() throws SortException{
        array.add(el1);
        array.add(el2);
        so.mergeSort(array, 0, array.size()-1);;
        assertEquals(2,array.size());
    }


    @Test
    public void testAddGet_oneEl_InsertioSort() throws SortException{
        array.add(el1);
        so.mergeSort(array, 0, array.size()-1);
        assertTrue(el1==array.get(0));
    }

    @Test
    public void testArray_threeEl_InsertioSort() throws SortException{

        array.add(el2);
        array.add(el1);
        array.add(el3);
        so.mergeSort(array, 0, array.size()-1);
        Integer[] arrExpected = {el1, el2, el3};

        Integer[] arrActual = new Integer[3];
        for (int i=0; i<3; i++)
            arrActual[i] = array.get(i);

        assertArrayEquals(arrActual,arrExpected);
    }

}
