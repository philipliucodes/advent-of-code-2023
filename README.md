# Advent of Code 2023

[adventofcode.com](adventofcode.com/2023)

This repository contains my solutions to the Advent of Code 2023 challenges. My solutions won't be the cleanest, but they get the job done. Happy holidays!

![image](https://github.com/philipliucodes/advent-of-code-2023/assets/143216542/b2deb1f8-4281-419d-8b51-5ccf488372c2)

## Day 4 Solutions:

### Part 1:

```
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
```

### Part 2:

```
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Day4Part2 {

    public static HashMap<Integer, Integer> copyMap = new HashMap<>();

    public static int getCardValue(int row, String input) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        String[] winningNumbers = input.split(":")[1].split("\\|")[0].replaceAll(" {2}", " ").split(" ");

        String[] yourNumbers = input.split(":")[1].split("\\|")[1].replaceAll(" {2}", " ").split(" ");

        for (String number : winningNumbers) {

            if (number != "") {

                int num = Integer.parseInt(number);

                if (!map.containsKey(num)) {

                    map.put(num, 1);

                }
            }
        }

        for (String number : yourNumbers) {

            if (number != "") {

                int num = Integer.parseInt(number);

                if (map.containsKey(num)) {

                    sum++;

                }
            }
        }

        for (int j = 0; j < copyMap.get(row); j++) {

            for (int i = 1; i <= sum; i++) {

                copyMap.put(row + i, copyMap.get(row + i) + 1);

            }
        }

        return copyMap.get(row);

    }

    public static void main(String[] args) throws IOException {

        int sum = 0;

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader2.readLine();

        int row = 0;

        while (input != null) {

            row++;
            copyMap.put(row, 1);
            input = bufferedReader2.readLine();

        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        input = bufferedReader.readLine();

        row = 0;

        while (input != null) {

            row++;
            sum += getCardValue(row, input);

            System.out.println(sum);

            input = bufferedReader.readLine();

        }

        System.out.println(sum);

    }
}
```
