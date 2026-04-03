import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface ReadInput {
    List<List<Integer>> readInput();
}

interface FilterData {
    List<List<Integer>> filterData(List<List<Integer>> li);
}

class MyOperations {
    // Write your code here

    static ReadInput readInput() {
        return () -> new ArrayList<>();
    }

    static FilterData filterData() {
        return li -> li;
    }
}

public class TryoutJava8FilteringTemplate {
    public static void main(String[] args) throws Exception {
        ReadInput readInput;
        readInput = MyOperations.readInput();

        List<List<Integer>> li = readInput.readInput();

        FilterData filterData;
        filterData = MyOperations.filterData();

        li = filterData.filterData(li);

        for (List<Integer> l : li) {
            for (Integer i : l) {
                System.out.println(i);
            }
        }
    }
}
