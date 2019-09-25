package sum;

import java.util.ArrayList;
import sort.SortException;

public class Sum{

    /**
     *  Precondition: The array list must to be order
     *
     *  The function search belong the list list, with two index, two elements
     *  that give number as their sum
     *  @param  list the list to be ordered
     *  @param  number the result of the sum given by the sum of two elements of list
     *  @return true if the sum between the value in position i and the
     *  value in position j of list is equal to the number
     */
    public boolean sum(ArrayList<Long> list, long number) throws SortException {
      if(list == null)
        throw new SortException("sum: list cannot be null");

      int i = 0;
      int j = list.size() - 1;
      long sum = 0;
      while(i < j){
        sum = list.get(i) + list.get(j);
        if(sum == number)
          return true;
        else if(sum > number)
          j--;
        else
          i++;
      }
      return false;
    }

}
