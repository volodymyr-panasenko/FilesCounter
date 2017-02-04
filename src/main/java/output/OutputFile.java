package output;

import entity.Directory;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputFile {

    /**
     * Write the result of counting files in a directory to a file
     * in CSV format: directory path;number of files in the directory
     *
     * @param directory
     * @param outputFileName - name of the output file
     */
    public void writeFile(Directory directory, String outputFileName) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFileName, true), "UTF-8"))) {
            bw.write(directory.getPath() + ';' + directory.getFiles() + '\n');
        } catch (IOException ex) {
            System.out.println("Error was detected while writing to the file");
        }
    }

}
