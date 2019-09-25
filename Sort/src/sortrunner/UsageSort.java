package sortrunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import sort.*;
import sum.*;


public class UsageSort{

  /**
   * Read the contents of the given file and adds each object contained therein
   * to the given array.
   *
   * @param  inputFile        the path of the file to be read
   * @param  array            the array to be used to store the contents
   *                          of the file
   */
  private static void readFile(String inputFile, ArrayList<Long> array){
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));

      System.out.println("Loading file... " + inputFile);

      String line;
      while((line = reader.readLine()) != null)
        array.add(Long.parseLong(line));

      reader.close();
      System.out.println("File loaded... "  + inputFile  + "\n");
    }
    catch (IOException ex){
      System.out.println("File error "  + inputFile + "\n");
    }
  }

  /**
   * The function calls sum function for any element of a and print result
   *
   * @param  arrayIntegers        the array to look for two elements thet give
   *                              an element of orraySums as their sum
   * @param  arraySums            the array to look for the sum
   */
  private static void sumRunner(ArrayList<Long> arrayIntegers, ArrayList<Long> arraySums) throws SortException{
    Sort<Long> s = new Sort<Long>(new LongComparator());
    Sum su = new Sum();

    boolean result = false;

    s.mergeSort(arrayIntegers, 0, arrayIntegers.size() - 1);

    for(int i = 0; i < arraySums.size(); i++){
      result = su.sum(arrayIntegers, arraySums.get(i));

      System.out.println("Found number " + arraySums.get(i) + " in sums.txt: " + result);
    }
  }

  /*
   *  Main
   */
  public static void main(String[] args) throws Exception, SortException{

    ArrayList<Long> arrayIntegers = new ArrayList<Long>();
    ArrayList<Long> arraySums = new ArrayList<Long>();
    Sort<Long> s = new Sort<Long>(new LongComparator());
    long startTime;

    if(args.length < 1)
      throw new Exception("\nUsage: UsageSort <file_path>\n       UsageSort <file_path1> <file_path2>");

    readFile(args[0], arrayIntegers);

    if(args.length == 2){
      readFile(args[1], arraySums);

      startTime = System.currentTimeMillis();

      sumRunner(arrayIntegers, arraySums);
    }
    else{
      //s.insertionSort(array);
      startTime = System.currentTimeMillis();

      s.mergeSort(arrayIntegers, 0, arrayIntegers.size() - 1);
      System.out.println("--------------Sorted array:--------------");
      s.printArray(arrayIntegers);
    }

    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("\nProcessing time: " + totalTime/1000 + "s");
  }
}
