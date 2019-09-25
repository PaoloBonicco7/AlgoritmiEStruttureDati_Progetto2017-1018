package distance;

import java.lang.Math;
import java.lang.String;

public class Distance{

  private String firstString, secondString;
  private int[][] array;

  /**
   * Constructor for Distance
   *
   * @param firstString first String to analyze
   * @param secondString Second String to analyze
   */
  public Distance(String firstString, String secondString){
    this.firstString = firstString;
    this.secondString = secondString;
    array = new int[firstString.length()][secondString.length()];
  }

  /**
   *  analyzes two strings firstString and secondString and returns the edit distance between them.
   *
   *  @param i  index refer to firstString
   *  @param j  index refer to secondString
   *
   *  @return   an integer value that represent the edit distance between firstString and secondString
   */
  public int editDistance(int i, int j){
    if((firstString.length() - i) == 0)
      return secondString.length() - j;

    if((secondString.length() - j) == 0)
      return firstString.length() - i;

    return Math.min(Math.min(1 + editDistance(i, j+1), 1 + editDistance(i+1, j)), noop(i, j));
  }

  /**
   * Function used by editDistance, useful for compare 2 equals character
   *
   * @param  i Index for the first string, use for charAt
   * @param  j Index for the first string, use for charAt
   * @return the editDistance between the next position of the strings if the 2
   *          character are equals, else it return Integer.MAX_VALUE.
   */
  private int noop(int i, int j){
    if(firstString.charAt(i) == secondString.charAt(j))
      return editDistance(i+1, j+1);

    return Integer.MAX_VALUE;
  }

  /**
   *  sets each element of the matrix m to Integer.MAX_VALUE and calls
   *  the dynamic version of editDistance.
   *
   *  @return   an integer value that represent the edit distance between firstString and secondString
   */
  public int editDistanceDynInit(){
    for(int i = 0; i <= firstString.length()-1; i++)
      for(int j = 0; j <= secondString.length()-1; j++)
        array[i][j] = Integer.MAX_VALUE;

    return editDistanceDyn(0, 0);
  }

  /**
   *  the function calculates the edit distance between every char of firstString and secondString
   *  and stores each of them in the corresponding cell of the matrix m.
   *
   *  @param i  index refer to firstString
   *  @param j  index refer to secondString
   *
   *  @return   an integer value that represent the edit distance between firstString and secondString
   */
  private int editDistanceDyn(int i, int j){
    if((firstString.length() - i) == 0)
      return secondString.length() - j;

    if((secondString.length() - j) == 0)
      return firstString.length() - i;

    if(array[i][j] == Integer.MAX_VALUE)
      array[i][j] = Math.min(Math.min(1 + editDistanceDyn(i, j+1), 1 + editDistanceDyn(i+1, j)), noopDyn(i, j));

    return array[i][j];
  }

  /**
   * Function used by editDistanceDyn, useful for compare 2 equals character
   *
   * @param  i Index for the first string, use for charAt
   * @param  j Index for the first string, use for charAt
   * @return the editDistanceDyn between the next position of the strings if the 2
   *          character are equals, else it return Integer.MAX_VALUE.
   */
  private int noopDyn(int i, int j){
    if(firstString.charAt(i) == secondString.charAt(j))
      return editDistanceDyn(i+1, j+1);

    return Integer.MAX_VALUE;
  }
}
