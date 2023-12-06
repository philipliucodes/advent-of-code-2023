import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day6Part2 {

    public static void main(String[] args) throws IOException {

        int product = 1;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        int count = 0;

        for (int i = 1; i < 54946592; i++) {

            long distance = (long) (54946592 - i) * i / 1000;

            if (distance > 302147610291.404) {

                count++;

            }
        }

        System.out.println(count);

    }
}
