package runningShop;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Run run = new Run(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))));
        
        
        System.out.println("Hello, World!");
        run.startRun();
    }
}
