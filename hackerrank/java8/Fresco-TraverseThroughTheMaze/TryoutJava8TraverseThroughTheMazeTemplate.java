import java.io.*;
import java.util.*;

class MazeTemplate {
    String[] traverseMaze(int size, String[][] maze) {
        // Enter your code here
        return new String[] {"0", ""};
    }
}

public class TryoutJava8TraverseThroughTheMazeTemplate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, len, size;
        String inputStr;

        size = Integer.parseInt(br.readLine().trim()); // for the size of the Maze

        String[][] maze = new String[size][size];
        for (i = 0; i < size; i++) {
            inputStr = br.readLine();
            maze[i] = inputStr.split(" ");
        }

        // storing elements in maze = }{, {}, X and O
        MazeTemplate m1 = new MazeTemplate();
        String[] answer = m1.traverseMaze(size, maze);

        if (answer[0].equals("0")) {
            System.out.println("The end of the maze could not be reached.");
        } else {
            len = answer[1].length();
            System.out.println(answer[0] + " steps are needed to reach the end of the maze.");

            for (i = 0; i < len; i++) {
                if (i == 0) {
                    System.out.print("The path traversed through the Maze is: " + answer[1].charAt(i));
                } else if ((i == 1) || (i == len - 1)) {
                    System.out.print(answer[1].charAt(i));
                } else {
                    // no need space between entry & exit position braces
                    System.out.print(" " + answer[1].charAt(i));
                }
            }
            System.out.println();
        }
    }
}
