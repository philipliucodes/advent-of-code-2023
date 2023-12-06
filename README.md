# Advent of Code 2023

[adventofcode.com](adventofcode.com/2023)

This repository contains my solutions to the Advent of Code 2023 challenges. My solutions won't be the cleanest. Happy holidays!

![image](https://github.com/philipliucodes/advent-of-code-2023/assets/143216542/b2deb1f8-4281-419d-8b51-5ccf488372c2)

## Day 6 Solutions:

### Part 1:

```
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
```

### Part 2:

```
public class Day6Part2 {

    public static void main(String[] args) {

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
```
