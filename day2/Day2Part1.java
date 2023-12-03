import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2Part1 {

    public static int isPossible(String input) {

        String[] game = input.split(":");
        int id = Integer.parseInt(game[0].substring(5));

        String[] colors = game[1].split(";");

        for (String color : colors) {

            String[] bleh = color.split(",");

            for (String bluh : bleh) {

                String[] num = bluh.split(" ");

                if (num[2].contains("red")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > 12) {

                        return 0;

                    }

                } else if (num[2].contains("blue")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > 14) {

                        return 0;

                    }

                } else if (num[2].contains("green")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > 13) {

                        return 0;

                    }
                }
            }
        }

        return id;

    }

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        while (input != null) {

            sum += isPossible(input);
            input = bufferedReader.readLine();

        }

        System.out.println(sum);

    }
}
