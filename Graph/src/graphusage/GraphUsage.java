package graphusage;

import java.io.BufferedReader;
import java.lang.String;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import minheap.*;
import graph.*;

public class GraphUsage{

  /**
   * Read the contents of the given file and adds each object contained therein
   * to the given array.
   *
   * @param  inputFile        the path of the file to be read
   * @param  array            the array to be used to store the contents
   *                          of the file
   */
  public static String loadFile(String inputFile, WeightGraph<String> graph) throws GraphException{

    String line = "";
    String[] words;
    String startVertex = null;
    Boolean firstTime = true;

    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));

      System.out.println("Loading file... \"italian_dist_graph\"");

      while((line = reader.readLine()) != null){

        words = line.split(",");
          graph.fillGraph(graph, words[0], words[1], Double.parseDouble(words[2]));

        if(firstTime){
          startVertex = words[0];
          firstTime = false;
        }
      }
      reader.close();
      System.out.println("File loaded... \"italian_dist_graph\"\n");
    }
    catch(IOException ex){
      System.out.println("File not found");
    }

    return startVertex;
  }

  public static void main(String[] args) throws Exception, GraphException, MinHeapException {
    if(args.length < 1)
      throw new Exception("\nUsage: GraphUsage <file_path>");

    WeightGraph<String> graph = new WeightGraph<String>(false, new StringComparator(), new DoubleComparator());
    Prim<String> primGraph = new Prim<String>(graph, new DoubleComparator());
    long startTime;

    String startVertex = loadFile(args[0], graph);

    startTime = System.currentTimeMillis();
    WeightGraph<String> result = primGraph.prim(startVertex);

    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("\tProcessing time: " + totalTime/1000 + "s");

    //result.printMap();
    result.printStats();
  }
}
