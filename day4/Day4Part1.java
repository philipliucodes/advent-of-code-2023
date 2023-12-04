import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day4Part1 {

    public static int getCardValue(String input) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        String[] winningNumbers = input.split(":")[1].split("\\|")[1].split(" ");
        String[] yourNumbers = input.split(":")[1].split("\\|")[0].split(" ");

        for (String number : winningNumbers) {

            int num = Integer.parseInt(number);

            if (!map.containsKey(num)) {

                map.put(num, 1);

            }
        }

        for (String number : yourNumbers) {

            int num = Integer.parseInt(number);

            if (map.containsKey(num)) {

                if (sum == 0) {

                    sum++;

                } else {

                    sum *= 2;

                }
            }
        }

        return sum;

    }

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        while (input != null) {

            sum += getCardValue(input);
            input = bufferedReader.readLine();

        }

        System.out.println(sum);

    }
}
