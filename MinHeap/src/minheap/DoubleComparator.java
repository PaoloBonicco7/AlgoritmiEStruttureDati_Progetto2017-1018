package minheap;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double>{

  /**
  * Override the compare method in the interface Comparator
  * to handle Double objects

  * @param  o1  the first object to be compared
  * @param  o2  the second object to be compared
  */
  @Override
  public int compare(Double o1, Double o2){
    return o1.compareTo(o2);
  }
}
