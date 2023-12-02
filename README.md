# Advent of Code 2023

adventofcode.com/2023

Solutions:

Day 1:

Part 1:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

```

public class Day1Part1 {

    public static int getValue(String input) {

        int value = 0;

        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))) {

                value += (input.charAt(i) - 48) * 10;
                break;

            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {

            if (Character.isDigit(input.charAt(i))) {

                value += input.charAt(i) - 48;
                break;

            }
        }

        return value;

    }

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        while (input != null) {

            sum += getValue(input);
            input = bufferedReader.readLine();

        }

        System.out.println(sum);

    }
}

```

Part 2:

Day 2:

Part 1:

Part 2:
