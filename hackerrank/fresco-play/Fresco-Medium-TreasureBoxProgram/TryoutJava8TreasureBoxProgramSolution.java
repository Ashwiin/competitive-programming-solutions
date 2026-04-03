import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TreasureHunt {
    public static char[][] fillingKeys(int order, char clue) {
        // BEGINNER NOTE: This 2D array represents the treasure box grid.
        char[][] grid = new char[order][order];

        // BEGINNER NOTE: Convert character to index in alphabet (A=0, B=1, ..., Z=25).
        int current = clue - 'A';
        // BEGINNER NOTE: "Skip order alphabets" means move by (order + 1) positions.
        int jump = order + 1; // skipping 'order' letters means moving by order+1

        // BEGINNER NOTE: Fill cells left-to-right, top-to-bottom.
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                // BEGINNER NOTE: Convert index back to uppercase letter.
                grid[i][j] = (char) ('A' + current);
                // BEGINNER NOTE: % 26 wraps around after Z back to A.
                current = (current + jump) % 26;
            }
        }

        return grid;
    }

    public static int possibleLockOrders(
        char sourceLock,
        char destinationLock,
        char[][] finalArray,
        int sourceRow,
        int destinationRow
    ) {
        // BEGINNER NOTE: Requirement says if both lock and row are same, answer should be 0.
        // As specified: same lock in same row returns 0.
        if (sourceLock == destinationLock && sourceRow == destinationRow) {
            return 0;
        }

        int order = finalArray.length;
        // BEGINNER NOTE: Input rows are 1-based; arrays are 0-based.
        int srcRow = sourceRow - 1;
        int dstRow = destinationRow - 1;

        // BEGINNER NOTE: Guard against invalid row inputs.
        if (srcRow < 0 || srcRow >= order || dstRow < 0 || dstRow >= order) {
            return 0;
        }

        int srcCol = -1;
        int dstCol = -1;

        // BEGINNER NOTE: Find the source and destination columns inside their rows.
        for (int c = 0; c < order; c++) {
            if (finalArray[srcRow][c] == sourceLock && srcCol == -1) {
                srcCol = c;
            }
            if (finalArray[dstRow][c] == destinationLock && dstCol == -1) {
                dstCol = c;
            }
        }

        // BEGINNER NOTE: If locks are not found in expected rows, return 0.
        if (srcCol == -1 || dstCol == -1) {
            return 0;
        }

        // BEGINNER NOTE: Shortest path uses minimum vertical + horizontal moves.
        int rowMoves = Math.abs(dstRow - srcRow);
        int colMoves = Math.abs(dstCol - srcCol);

        // BEGINNER NOTE: Number of shortest paths in a grid = combinations.
        // Number of shortest paths in a grid = C(rowMoves + colMoves, rowMoves)
        return nCr(rowMoves + colMoves, rowMoves);
    }

    private static int nCr(int n, int r) {
        // BEGINNER NOTE: Standard combination edge checks.
        if (r < 0 || r > n) {
            return 0;
        }

        // BEGINNER NOTE: Use smaller r to reduce multiplications.
        r = Math.min(r, n - r);
        long ans = 1;

        // BEGINNER NOTE: Multiplicative formula for nCr without factorial overflow.
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
        }

        return (int) ans;
    }
}

public class TryoutJava8TreasureBoxProgramSolution {
    public static void main(String[] args) throws IOException {
        // BEGINNER NOTE: BufferedReader is faster for competitive programming input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // BEGINNER NOTE: Read all required inputs in the order specified by problem.
        int order = Integer.parseInt(br.readLine().trim());
        int sourceRow = Integer.parseInt(br.readLine().trim());
        int destinationRow = Integer.parseInt(br.readLine().trim());
        String input = br.readLine();

        // BEGINNER NOTE: input string contains exactly 3 chars: clue, sourceLock, destinationLock.
        char clue = input.charAt(0);
        char sourceLock = input.charAt(1);
        char destinationLock = input.charAt(2);

        // BEGINNER NOTE: Build the filled key grid first.
        char[][] result = TreasureHunt.fillingKeys(order, clue);

        // BEGINNER NOTE: Print grid exactly as required.
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        // BEGINNER NOTE: Compute and print number of shortest ways.
        int result1 = TreasureHunt.possibleLockOrders(
            sourceLock,
            destinationLock,
            result,
            sourceRow,
            destinationRow
        );
        System.out.println(result1);

        br.close();
    }
}
