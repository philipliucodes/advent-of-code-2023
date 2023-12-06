import java.util.HashMap;
import java.util.Map;

public class Day6Part1 {

    public static void main(String[] args) {

        int product = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(94, 1476);
        map.put(65, 1029);
        map.put(92, 1404);

        for (Map.Entry<Integer, Integer> record : map.entrySet()) {

            int count = 0;

            for (int i = 1; i < record.getKey(); i++) {

                int distance = (record.getKey() - i) * i;

                if (distance > record.getValue()) {

                    count++;

                }
            }

            product *= count;

        }

        System.out.println(product);

    }
}
