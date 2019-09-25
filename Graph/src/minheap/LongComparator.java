package minheap;

import java.util.Comparator;

public class LongComparator implements Comparator<Long>{

  /**
  * Override the compare method in the interface Comparator
  * to handle Long objects

  * @param  o1  the first object to be compared
  * @param  o2  the second object to be compared
  */
  @Override
  public int compare(Long o1, Long o2){
    return o1.compareTo(o2);
  }
}
