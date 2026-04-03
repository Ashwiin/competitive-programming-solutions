import java.io.*;
import java.util.*;

class Maze {
    String[] traverseMaze(int size, String[][] maze) {
        // BEGINNER NOTE: We first find where entry (}{) and exit ({}) are located.
        int startR = -1, startC = -1;
        int endR = -1, endC = -1;

        // Locate entry and exit positions.
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (maze[r][c].equals("}{")) {
                    startR = r;
                    startC = c;
                } else if (maze[r][c].equals("{}")) {
                    endR = r;
                    endC = c;
                }
            }
        }

        // BEGINNER NOTE: If either entry or exit is missing, maze is invalid/unreachable.
        if (startR == -1 || endR == -1) {
            return new String[] {"0", ""};
        }

        // BEGINNER NOTE: BFS arrays
        // dist[r][c]    = shortest distance from entry to this cell
        // parentR/C     = previous cell used to reconstruct the shortest path
        // BFS for shortest distance and path reconstruction.
        int[][] dist = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dist[i], -1);
        }

        int[][] parentR = new int[size][size];
        int[][] parentC = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(parentR[i], -1);
            Arrays.fill(parentC[i], -1);
        }

        // BEGINNER NOTE: Movement in 4 directions: up, down, left, right.
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BEGINNER NOTE: Standard BFS queue, starting from entry.
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startR, startC});
        dist[startR][startC] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == endR && c == endC) {
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
                    continue;
                }

                String cell = maze[nr][nc];
                // BEGINNER NOTE: Cannot pass through walls.
                if (cell.equals("X")) {
                    continue;
                }

                // BEGINNER NOTE: Already visited means shortest distance is already known.
                if (dist[nr][nc] != -1) {
                    continue;
                }

                // BEGINNER NOTE: First time visit in BFS gives shortest distance.
                dist[nr][nc] = dist[r][c] + 1;
                parentR[nr][nc] = r;
                parentC[nr][nc] = c;
                q.add(new int[] {nr, nc});
            }
        }

        // BEGINNER NOTE: If exit was never visited, maze end is unreachable.
        if (dist[endR][endC] == -1) {
            return new String[] {"0", ""};
        }

        // BEGINNER NOTE: Reconstruct path by walking backward from exit to entry
        // using parent pointers, then reverse to get entry -> exit order.
        // Reconstruct path from end to start, then reverse.
        List<String> pathCells = new ArrayList<>();
        int cr = endR, cc = endC;
        while (!(cr == -1 && cc == -1)) {
            pathCells.add(maze[cr][cc]);
            int pr = parentR[cr][cc];
            int pc = parentC[cr][cc];
            cr = pr;
            cc = pc;
        }
        Collections.reverse(pathCells);

        // BEGINNER NOTE: Build a compact token string from path cells.
        // Example tokens: "}{", "O", "O", "{}" => path string for template printer.
        // Build compact path string in same style as provided template logic.
        StringBuilder sb = new StringBuilder();
        for (String token : pathCells) {
            sb.append(token);
        }

        String steps = String.valueOf(dist[endR][endC]);
        String path = sb.toString();
        return new String[] {steps, path};
    }
}

public class TryoutJava8TraverseThroughTheMazeSolution {
    public static void main(String[] args) throws Exception {
        // BEGINNER NOTE: BufferedReader reads input faster for coding challenges.
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
        Maze m1 = new Maze();
        String[] answer = m1.traverseMaze(size, maze);

        // BEGINNER NOTE: answer[0] is steps, answer[1] is path string.
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

        br.close();
    }
}
