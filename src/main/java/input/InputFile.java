package input;

import java.io.*;
import java.util.ArrayList;

public class InputFile {

    /**
     * Read the file line by line and return list of paths
     *
     * @param inputFileName - name of the input file
     * @return ArrayList<String> - list of paths
     */
    public ArrayList<String> getPaths(String inputFileName) {
        ArrayList<String> paths = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputFileName), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (new File(line).isDirectory()) {
                    paths.add(line);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error was detected while reading the file");
        }
        return paths;
    }

}
