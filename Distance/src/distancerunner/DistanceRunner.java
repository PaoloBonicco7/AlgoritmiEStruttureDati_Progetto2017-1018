package distancerunner;

import java.util.ArrayList;
import java.io.IOException;
import distance.DistanceException;

public class DistanceRunner{

  /*
   *  Main
   */
  public static void main(String[] args) throws Exception, DistanceException, IOException{

    if(args.length < 1)
      throw new Exception("\nUsage: DistanceRunner <file_name1> <file_name2>");

    ArrayList<String> arrayCorrectMe = new ArrayList<String>();
    ArrayList<String> arrayDictionary = new ArrayList<String>();

    UsageDistance.loadFile(args[0], arrayCorrectMe);
    UsageDistance.loadFile(arrayDictionary, args[1]);

    UsageDistance.editDistanceLauncher(arrayCorrectMe, arrayDictionary);
  }

}
