# Advent of Code 2023

[adventofcode.com](adventofcode.com/2023)

This repository contains my solutions to the Advent of Code 2023 challenges. My solutions won't be the cleanest, but they get the job done. Happy holidays!

![image](https://github.com/philipliucodes/advent-of-code-2023/assets/143216542/b2deb1f8-4281-419d-8b51-5ccf488372c2)

## Day 5 Solutions:

### Part 1:

```
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Day5Part1 {

    public static ArrayList<Long> traverseMap(ArrayList<String> ranges, ArrayList<Long> seeds) {

        HashMap<long[], long[]> map = new HashMap<>();

        for (String range : ranges) {

            long[] sources = new long[3];

            for (int i = 0; i < 3; i++) {

                sources[i] = Long.parseLong(range.split(" ")[i]);

            }

            long[] sourceRange = {sources[1], sources[1] + sources[2]};
            long[] destinationRange = {sources[0], sources[0] + sources[2]};

            map.put(sourceRange, destinationRange);

        }

        for (int i = 0; i < seeds.size(); i++) {

            for (Map.Entry<long[], long[]> entryRange : map.entrySet()) {

                long min = entryRange.getKey()[0];
                long max = entryRange.getKey()[1];

                if ((seeds.get(i) >= min && seeds.get(i) <= max) || (seeds.get(i) <= min && seeds.get(i) >= max)) {

                    long diff = seeds.get(i) - min;
                    seeds.set(i, entryRange.getValue()[0] + diff);

                    break;

                }
            }
        }

        return seeds;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        ArrayList<Long> seeds = new ArrayList<>();

        for (String seed : input.split(":")[1].replaceFirst(" ", "").split(" ")) {

            seeds.add(Long.parseLong(seed));

        }

        while (input != null) {

            input = bufferedReader.readLine();

            ArrayList<String> ranges = new ArrayList<>();

            while (input != null && !input.isEmpty()) {

                input = bufferedReader.readLine();

                if (input != null && !input.isEmpty()) {

                    ranges.add(input);

                }
            }

            seeds = traverseMap(ranges, seeds);

        }

        Collections.sort(seeds);

        System.out.println(seeds.get(0));

    }
}
```

### Part 2:

```
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// doesn't work, runs into OutOfMemory Error

public class Day5Part2 {

    public static HashMap<long[], long[]> seedMap = new HashMap<>();

    public static ArrayList<Long> traverseMap(ArrayList<String> ranges, ArrayList<Long> seeds) {

        HashMap<long[], long[]> map = new HashMap<>();

        for (String range : ranges) {

            long[] sources = new long[3];

            for (int i = 0; i < 3; i++) {

                sources[i] = Long.parseLong(range.split(" ")[i]);

            }

            long[] sourceRange = {sources[1], sources[1] + sources[2]};
            long[] destinationRange = {sources[0], sources[0] + sources[2]};

            map.put(sourceRange, destinationRange);

        }

        for (int i = 0; i < seeds.size(); i++) {

            for (Map.Entry<long[], long[]> entryRange : map.entrySet()) {

                long min = entryRange.getKey()[0];
                long max = entryRange.getKey()[1];

                if ((seeds.get(i) >= min && seeds.get(i) <= max) || (seeds.get(i) <= min && seeds.get(i) >= max)) {

                    long diff = seeds.get(i) - min;
                    seeds.set(i, entryRange.getValue()[0] + diff);

                    break;

                }
            }
        }

        return seeds;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        ArrayList<Long> seeds = new ArrayList<>();
        ArrayList<Long> seedRanges = new ArrayList<>();

        for (String seed : input.split(":")[1].replaceFirst(" ", "").split(" ")) {

            seedRanges.add(Long.parseLong(seed));

            if (seedRanges.size() == 2) {

                if (seedRanges.get(0) < seedRanges.get(1)) {

                    for (Long i = seedRanges.get(0); i <= seedRanges.get(1); i++) {

                        seeds.add(i);

                    }

                } else {

                    for (Long i = seedRanges.get(1); i <= seedRanges.get(0); i++) {

                        seeds.add(i);

                    }
                }

                seedRanges = new ArrayList<>();

            }
        }

        while (input != null) {

            input = bufferedReader.readLine();

            ArrayList<String> ranges = new ArrayList<>();

            while (input != null && !input.isEmpty()) {

                input = bufferedReader.readLine();

                if (input != null && !input.isEmpty()) {

                    ranges.add(input);

                }
            }

            seeds = traverseMap(ranges, seeds);

        }

        Collections.sort(seeds);

        System.out.println(seeds.get(0));

    }
}
```
