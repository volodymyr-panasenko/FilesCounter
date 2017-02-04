package output;

import entity.Directory;

public class Screen {

    public void display(int index, Directory directory) {
        System.out.println(index + "\t" + directory.getFiles() + "\t" + directory.getPath());
    }

}
