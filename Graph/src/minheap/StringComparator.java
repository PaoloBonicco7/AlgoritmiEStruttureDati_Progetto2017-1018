package minheap;

import java.util.Comparator;

public class StringComparator implements Comparator<String>{

  /**
  * Override the compare method in the interface Comparator
  * to handle String objects

  * @param  o1  the first object to be compared
  * @param  o2  the second object to be compared
  */
  @Override
  public int compare(String o1, String o2){
    return o1.compareTo(o2);
  }
}
