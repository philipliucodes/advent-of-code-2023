# Advent of Code 2023

[adventofcode.com](adventofcode.com/2023)

This repository contains my solutions to the Advent of Code 2023 challenges. My solutions won't be the cleanest, but they get the job done. Happy holidays!

![image](https://github.com/philipliucodes/advent-of-code-2023/assets/143216542/b2deb1f8-4281-419d-8b51-5ccf488372c2)

## Day 3 Solutions:

### Part 1:

```
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day3Part1 {

    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void createMap(int row, String input) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.') {

                list.add(i);

            }
        }

        map.put(row, list);

    }

    public static int buildSumFromEachRow(int row, String input, int tableLength) {

        int[] range = {-1, -1};
        boolean started = false;
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {

            boolean valid = false;

            if (Character.isDigit(input.charAt(i)) && i != input.length() - 1) {

                if (!started) {

                    started = true;
                    range[0] = i;

                }

            } else if (i == input.length() - 1 && Character.isDigit(input.charAt(i))) {

                if (started) {

                    started = false;
                    range[1] = i;

                    if (row == 1) {

                        if (!map.get(row).isEmpty()) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row + 1).isEmpty() && !valid) {

                            for (int num : map.get(row + 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }

                    } else if (row == tableLength) {

                        if (!map.get(row - 1).isEmpty()) {

                            for (int num : map.get(row - 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row).isEmpty() && !valid) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }

                    } else {

                        if (!map.get(row).isEmpty()) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row - 1).isEmpty() && !valid) {

                            for (int num : map.get(row - 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row + 1).isEmpty() && !valid) {

                            for (int num : map.get(row + 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }
                    }
                }

            } else {

                if (started) {

                    started = false;
                    range[1] = i - 1;

                    if (row == 1) {

                        if (!map.get(row).isEmpty()) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row + 1).isEmpty() && !valid) {

                            for (int num : map.get(row + 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }

                    } else if (row == tableLength) {

                        if (!map.get(row - 1).isEmpty()) {

                            for (int num : map.get(row - 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row).isEmpty() && !valid) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }

                    } else {

                        if (!map.get(row).isEmpty()) {

                            for (int num : map.get(row)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row - 1).isEmpty() && !valid) {

                            for (int num : map.get(row - 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (!map.get(row + 1).isEmpty() && !valid) {

                            for (int num : map.get(row + 1)) {

                                if (num >= range[0] - 1 && num <= range[1] + 1) {

                                    valid = true;

                                }
                            }
                        }

                        if (valid) {

                            sum += Integer.parseInt(input.substring(range[0], range[1] + 1));

                            valid = false;

                        }
                    }
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) throws IOException {

        int sum = 0;
        int row = 1;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String input = bufferedReader.readLine();

        while (input != null) {

            createMap(row, input);
            input = bufferedReader.readLine();
            row++;

        }

        int tableLength = row - 1;

        row = 1;

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("input.txt"));
        input = bufferedReader2.readLine();

        while (input != null) {

            sum += buildSumFromEachRow(row, input, tableLength);
            input = bufferedReader2.readLine();
            row++;

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

public class Day2Part2 {

    public static int isPossible(String input) {

        int blue = 0;
        int green = 0;
        int red = 0;

        String[] game = input.split(":");
        int id = Integer.parseInt(game[0].substring(5));

        String[] colors = game[1].split(";");

        for (String color : colors) {

            String[] bleh = color.split(",");

            for (String bluh : bleh) {

                String[] num = bluh.split(" ");

                if (num[2].contains("red")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > red) {

                        red = amount;

                    }

                } else if (num[2].contains("blue")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > blue) {

                        blue = amount;

                    }

                } else if (num[2].contains("green")) {

                    int amount = Integer.parseInt(num[1]);

                    if (amount > green) {

                        green = amount;

                    }
                }
            }
        }

        return blue * green * red;

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
```
