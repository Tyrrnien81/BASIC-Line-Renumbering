import java.util.*;
import java.io.*;

/**
 * Renumbers the lines of a valid BASIC program.
 *
 * @Yeongjun Jeong
 * @12/16/2022
 */
public class Project4 {
    public static void main(String[] args) {
        // check the command-line arguments
        if (args.length != 3) {
            System.err.println("Please enter three command-line arguments.");
            System.exit(1);
        }

        String name = args[0];
        int start = Integer.parseInt(args[1]);
        int interval = Integer.parseInt(args[2]);

        // check the start and increment values
        if (start < 0 || interval <= 0) {
            System.err.println("Number Format Exception: input 2 numbers.");
            System.exit(1);
        }

        HashMap<String, Integer> map = null;
        ArrayList<String[]> list = null;
        FileInputStream readfile = null;
        PrintWriter pw = null;
        Scanner in = null;

        try {
            readfile = new FileInputStream(name);
            in = new Scanner(readfile);
            map = new HashMap<String, Integer>();
            list = new ArrayList<String[]>();

            while (in.hasNextLine()) {
                // read BASIC file
                String line = in.nextLine();

                // split the line and store to Arrylist
                String[] lines = line.split(" ");
                list.add(lines);

                // store the line number to Hashmap
                // key = new line number, value = original line number
                map.put(lines[0], start);
                start = start + interval;
            }

            // check if there is a code that refers to a particular line number
            for (String[] array : list) {
                // change original line number to new line number
                array[0] = map.get(array[0]) + "";

                for (int i = 0; i < array.length; i++) {
                    // after "THEN", "TO", and "GOSUB" the line number comes
                    if (array[i].equals("THEN") || array[i].equals("TO") || array[i].equals("GOSUB")) {
                        // update the line number that follow the particular code
                        array[i + 1] = map.get(array[i + 1]) + "";
                    }
                }
            }

            // print the line that store in the Arraylist
            for (String[] array : list) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.print("\n");
            }
            in.close();
            readfile.close();
        } catch (IOException e) {
            System.out.println("input output exception");
        }
    }
}
