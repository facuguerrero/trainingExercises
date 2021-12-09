import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'calcMissing' function below.
     *
     * The function accepts STRING_ARRAY readings as parameter.
     */

    public static void calcMissing(List<String> readings) {
        // Write your code here
        List<String> mercuryLevels = readings.stream()
                .map(reading -> {
                    String[] splittedReading = reading.split("\\s+");
                    return splittedReading[2];
                })
                .collect(Collectors.toList());

        if (mercuryLevels.get(0).contains("Missing")) {
            int firstNeighbourIndex = getNextNeighbourForwardIndex(mercuryLevels, 1);
            int secondNeighbourIndex = getNextNeighbourForwardIndex(mercuryLevels, firstNeighbourIndex);

            int betweenElements = secondNeighbourIndex - firstNeighbourIndex;

            double firstNeighbourValue = Double.parseDouble(mercuryLevels.get(firstNeighbourIndex));
            double secondNeighbourValue = Double.parseDouble(mercuryLevels.get(secondNeighbourIndex));

            double estimatedValue = firstNeighbourValue - (((firstNeighbourValue-secondNeighbourValue)/betweenElements)*firstNeighbourIndex);

            System.out.println(estimatedValue);
        }

        for(int i=1; i<mercuryLevels.size()-1; i++){
            if(readings.get(i).contains("Missing")){
                int ij = getNextNeighbourBackwardIndex(mercuryLevels, i-1);
                int ik = getNextNeighbourForwardIndex(mercuryLevels, i+1);
                int j = Math.abs(ij-i);
                int k = Math.abs(ik-1);
                double ij_data = Double.parseDouble(mercuryLevels.get(ij));
                double ik_data = Double.parseDouble(mercuryLevels.get(ik));
                double result = ij_data + ((ik_data-ij_data)/(k+j))*j;
                System.out.println(result);
            }
        }

        int lastElement = mercuryLevels.size() - 1;
        if (mercuryLevels.get(lastElement).contains("Missing")) {
            int firstNeighbourIndex = getNextNeighbourBackwardIndex(mercuryLevels, lastElement - 2);
            int secondNeighbourIndex = getNextNeighbourBackwardIndex(mercuryLevels, firstNeighbourIndex - 1);

            int betweenElements = secondNeighbourIndex - firstNeighbourIndex;

            double firstNeighbourValue = Double.parseDouble(mercuryLevels.get(firstNeighbourIndex));
            double secondNeighbourValue = Double.parseDouble(mercuryLevels.get(secondNeighbourIndex));

            double estimatedValue = firstNeighbourValue + (((firstNeighbourValue-secondNeighbourValue)/betweenElements)*firstNeighbourIndex);

            System.out.println(estimatedValue);
        }
    }

    public static int getNextNeighbourForwardIndex(List<String> input, int start){
        for(int i=start; i<input.size(); i++){
            if(!input.get(i).contains("Missing")){
                return i;
            }
        }
        return 0;
    }

    public static int getNextNeighbourBackwardIndex(List<String> input, int start){
        for(int i=start; i>=0; i--){
            if(!input.get(i).contains("Missing")){
                return i;
            }
        }
        return 0;
    }

}
public class Solution {