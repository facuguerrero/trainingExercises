import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



class Solution {
    private static final String OUTPUT_FILE = "records_%s";
    private static final String OUTPUT_FORMAT = "%s %s \n";

    public static void main(String[] args) {
      hostsAndNumberOfRequests("test.txt");
    }

    public static void hostsAndNumberOfRequests(String filename) {
        Map<String, Integer> hostsCount = new HashMap<>();
        try {
            BufferedReader readBR = new BufferedReader(new FileReader(filename));
            String currentLine = readBR.readLine();
            while (currentLine != null) {
                System.out.println(currentLine);

                String[] splitedLine = currentLine.split("- -");
                String hostName = splitedLine[0];
                Integer currentHostCount = hostsCount.getOrDefault(hostName, 0) + 1;
                hostsCount.put(hostName, currentHostCount);

                currentLine = readBR.readLine();
            }

            FileWriter fileWriter = new FileWriter(String.format(OUTPUT_FILE, filename));
            for (Map.Entry<String,Integer> host : hostsCount.entrySet()) {
                fileWriter.write(String.format(OUTPUT_FORMAT, host.getKey(), host.getValue()));
            }
            fileWriter.close();


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
