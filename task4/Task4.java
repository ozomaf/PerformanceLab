import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) throws Exception {

        List<Integer> array = readArray(args[0]);
        System.out.println(calculateMoves(array));
    }

    private static List<Integer> readArray(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Integer> array = new ArrayList<>();
            String num;
            while ((num = reader.readLine()) != null) {
                array.add(Integer.valueOf(num));
            }
            return array;
        }
    }

    private static int calculateMoves(List<Integer> array) {
        float sum = array.stream().mapToInt(Integer::intValue).sum();
        int middleValue = Math.round(sum / array.size());
        int cntMove = 0;
        for (Integer integer : array) {
            cntMove += Math.abs(integer - middleValue);
        }
        return cntMove;
    }

}