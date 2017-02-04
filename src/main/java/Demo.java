import handler.MainHandler;
import input.KeyListener;

public class Demo {

    static {
        System.out.println("Press Esc to cancel the running search " +
                "or to exit the program" + '\n');
        System.out.println("Index" + "\t" + "Files" + "\t" + "Path");
    }

    public static void main(String[] args) {
        KeyListener keyListener = new KeyListener();
        keyListener.run();

        String inputFileName = args[0];
        String outputFileName = args[1];
        MainHandler handler = new MainHandler();
        handler.getResults(inputFileName, outputFileName);
    }

}
