import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TreasureHuntTemplate {
    public static char[][] fillingKeys(int order, char clue) {
        // write your code here
        return new char[order][order];
    }

    public static int possibleLockOrders(
        char sourceLock,
        char destinationLock,
        char[][] finalArray,
        int sourceRow,
        int destinationRow
    ) {
        // write your code here
        return 0;
    }
}

public class TryoutJava8TreasureBoxProgramTemplate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int order = Integer.parseInt(br.readLine().trim());
        int sourceRow = Integer.parseInt(br.readLine().trim());
        int destinationRow = Integer.parseInt(br.readLine().trim());
        String input = br.readLine();

        char clue = input.charAt(0);
        char sourceLock = input.charAt(1);
        char destinationLock = input.charAt(2);

        char[][] result = TreasureHuntTemplate.fillingKeys(order, clue);

        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        int result1 = TreasureHuntTemplate.possibleLockOrders(
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
