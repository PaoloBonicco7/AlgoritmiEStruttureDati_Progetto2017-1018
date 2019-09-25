package sort;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort<T>{
  Comparator<T> comparator;

  /**
   * Constructor for SortArray
   * @param  Comparator is  a comparator object. The data structure will keep
   * the objects sorted according to the ordering induced by this comparator.
   */
  public Sort(Comparator<T> comparator){
    this.comparator = comparator;
  }

  /**
   * The function sorts the list array using comparator.
   * @param  array         the list to be sorted
   * @throws SortException the Exeption to throws
   */
  public void insertionSort(ArrayList<T> array) throws SortException{
    if(array == null)
      throw new SortException("insertionSort: array cannot be null");

    for(int i = 1; i < array.size(); i++){
      int j = i;
      while(j > 0 && comparator.compare(array.get(j), array.get(j-1)) < 0){
        swapElem(array, j, j-1);
        j--;
      }
    }
  }

  /**
   * The function swap two element in position i and j in the list array.
   * @param  array the list that contains the elements to be swapped
   * @param  i the index of the first element to swap
   * @param  j the index of the second element to swap
   */
  private void swapElem(ArrayList<T> array, int i, int j){
    T tmp;
    tmp = array.get(j);
    array.set(j, array.get(i));
    array.set(i, tmp);
  }

  /**
   * The function sorts the list array. It divides array in two halves and calls itself
   * for the two halves.
   * @param  array         the list to be sorted
   * @param  first          the first index of the list array
   * @param  last          the last index of the list array
   * @throws SortException the Exeption to throws
   */
  public void mergeSort(ArrayList<T> array, int first, int last) throws SortException{
    if(array == null)
      throw new SortException("mergeSort: array cannot be null");

    if(first < last){
      int middle = (first+last)/2;
      mergeSort(array, first, middle);
      mergeSort(array, middle+1, last);
      merge(array, first, middle, last);
    }
  }

  /**
   * The function merges the two sorted halves.
   *
   * @param array the list to be sorted
   * @param first the first index of the list array
   * @param middle the middle index of the list array
   * @param last the last index of the list array
   */
  private void merge(ArrayList<T> array, int first, int middle, int last){
    int i = first;
    int j = middle+1;
    ArrayList<T> aux = new ArrayList<T>();

    while(i <= middle && j <= last){
      if((comparator.compare(array.get(i), array.get(j))) <= 0){
        aux.add(array.get(i));
        i++;
      }
      else{
        aux.add(array.get(j));
        j++;
      }
    }

    while(i <= middle){
      aux.add(array.get(i));
      i++;
    }

    while(j <= last){
      aux.add(array.get(j));
      j++;
    }

    int p = 0;
    int q = first;
    while(p < aux.size()){
      array.set(q, aux.get(p++));
      q++;
    }
  }

  /**
   * The function print all the elementa of the list.
   *
   * @param list the list to be printed
   */
  public void printArray(ArrayList<T> list){
    for(int i = 0; i < list.size(); i++)
      System.out.println("\t" + list.get(i));
  }
}
