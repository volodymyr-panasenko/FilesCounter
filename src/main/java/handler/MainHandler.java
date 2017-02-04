package handler;

import entity.Directory;
import input.InputFile;
import output.OutputFile;
import output.Screen;

import java.io.*;
import java.util.List;

public class MainHandler {

    private InputFile inputFile = new InputFile();
    private OutputFile outputFile = new OutputFile();
    private Screen screen = new Screen();

    /**
     * Count the number of files in a directory and all its subdirectories
     *
     * @param dr - directory
     * @return int - number of files
     */
    public int getCountFiles(Directory dr) {
        int count = 0;
        File directory = new File(dr.getPath());
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Directory drct = new Directory(file.getAbsolutePath());
                count += getCountFiles(drct);
            } else if (file.isFile()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Write the results to a file and on the screen
     *
     * @param inputFileName  - name of the input file
     * @param outputFileName - name of the output file
     */
    public void getResults(String inputFileName, String outputFileName) {
        List<String> paths = inputFile.getPaths(inputFileName);
        for (int i = 0; i < paths.size(); i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String path = paths.get(j);
                    Directory directory = new Directory(path);
                    directory.setFiles(getCountFiles(directory));

                    outputFile.writeFile(directory, outputFileName);
                    screen.display((j + 1), directory);
                }
            }).start();
        }
    }

}

