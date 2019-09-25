package distancerunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.lang.String;
import java.io.FileReader;
import java.io.IOException;
import distance.DistanceException;
import distance.Distance;

public class UsageDistance{

  /**
   * Read the contents of the given file and adds each object contained there in
   * to the given array.
   *
   * @param  inputFile        the path of the file to be read
   * @param  array            the array to be used to store the contents
   *                          of the file
   */
  public static void loadFile(String inputFile, ArrayList<String> array){

    String line = "";
    String[] words;

    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));

      System.out.println("Loading file... \"CorrectMe\"");

      while((line = reader.readLine()) != null){

        line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        words = line.split(" ");
        for(int i = 0; i < words.length; i++)
          array.add(words[i]);
      }
      reader.close();
    }
    catch(IOException ex){
      System.out.println("File not found");
    }

    System.out.println("File loaded... \"CorrectMe\"\n");
  }

  /**
   * Read the contents of the given file and adds each object contained therein
   * to the given array.
   *
   * @param  array            the array to be used to store the contents
   *                          of the file
   * @param  inputFile        the path of the file to be read
   */
  public static void loadFile(ArrayList<String> array, String inputFile){

    String line = "";
    String[] words;

    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));

      System.out.println("Loading file... \"Dictionary\"");

      while((line = reader.readLine()) != null){

        words = line.split("\n");
        for(int i = 0; i < words.length; i++)
          array.add(words[i]);
      }
      reader.close();
    }
    catch(Exception ex){
      System.out.println("File not found");
    }

    System.out.println("File loaded... \"Dictionary\"\n");

  }

  /**
   * calls editDistanceDyn for each element of arrayCorrectMe and calculates
   * the minimum edit distance min from each element of arrayDictionary. The function
   * stores each word of arrayDictionary with minimum edit distance in the array
   * aux and prints it if min is greater than zero
   *
   * @param  arrayCorrectMe        the array which contains the phrase to be checked
   * @param  arrayDictionary       the array which contains the words to be compared
   *                               to the words in arrayCorrectMe
   */
  public static void editDistanceLauncher(ArrayList<String> arrayCorrectMe, ArrayList<String> arrayDictionary){
    int result = 0, min = Integer.MAX_VALUE;
    ArrayList<String> aux = new ArrayList<String>();
    Distance correctWords;

    for(int i = 0; i < arrayCorrectMe.size(); i++){
      for(int j = 0; j < arrayDictionary.size(); j++){
        correctWords = new Distance(arrayCorrectMe.get(i), arrayDictionary.get(j));

        result = correctWords.editDistanceDynInit();
        if(result < min){
          min = result;
          aux.clear();
          aux.add(arrayDictionary.get(j));
        }
        else if(result == min)
          aux.add(arrayDictionary.get(j));
      }

      System.out.println("Found word \"" + arrayCorrectMe.get(i) + "\" with edit distance " + min);
      printArray(aux);
      System.out.print("\n");

      aux.clear();
      min = Integer.MAX_VALUE;
    }
  }

  /**
   *  The function print all the elementa of the list l.
   *
   *  @param  l the list to be printed
   */
  public static void printArray(ArrayList<String> l){
    for(int i = 0; i < l.size(); i++)
      System.out.println("\t" + l.get(i));
  }

}
