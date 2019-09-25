package sort;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer>{

  /**
  * Override the compare method in the interface Comparator
  * to handle Integer objects

  * @param  o1  the first object to be compared
  * @param  o2  the second object to be compared
  */
  @Override
  public int compare(Integer o1, Integer o2){
    return o1.compareTo(o2);
  }
}
