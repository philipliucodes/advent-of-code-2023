# Advent of Code 2023

adventofcode.com/2023

Solutions:

Day 1:

Part 1:

```

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

```

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1Part2 {

    public static int getValue(String input) {

        String origInput = input;

        StringBuilder input1 = new StringBuilder();

        while (input.length() > 0) {

            if (Character.isDigit(input.charAt(0))) {

                input1.append(input.charAt(0));

                if (input.length() == 1) {

                    input = "";

                } else {

                    input = input.substring(1);

                }

            } else if (input.startsWith("one")) {

                input1.append('1');

                if (input.length() == 3) {

                    input = "";

                } else {

                    input = input.substring(3);

                }

            } else if (input.startsWith("two")) {

                input1.append('2');

                if (input.length() == 3) {

                    input = "";

                } else {

                    input = input.substring(3);

                }

            } else if (input.startsWith("three")) {

                input1.append('3');

                if (input.length() == 5) {

                    input = "";

                } else {

                    input = input.substring(5);

                }

            } else if (input.startsWith("four")) {

                input1.append('4');

                if (input.length() == 4) {

                    input = "";

                } else {

                    input = input.substring(4);

                }

            } else if (input.startsWith("five")) {

                input1.append('5');

                if (input.length() == 4) {

                    input = "";

                } else {

                    input = input.substring(4);

                }

            } else if (input.startsWith("six")) {

                input1.append('6');

                if (input.length() == 3) {

                    input = "";

                } else {

                    input = input.substring(3);

                }

            } else if (input.startsWith("seven")) {

                input1.append('7');

                if (input.length() == 5) {

                    input = "";

                } else {

                    input = input.substring(5);

                }

            } else if (input.startsWith("eight")) {

                input1.append('8');

                if (input.length() == 5) {

                    input = "";

                } else {

                    input = input.substring(5);

                }

            } else if (input.startsWith("nine")) {

                input1.append('9');

                if (input.length() == 4) {

                    input = "";

                } else {

                    input = input.substring(4);

                }

            } else {

                input1.append(input.charAt(0));

                if (input.length() == 1) {

                    input = "";

                } else {

                    input = input.substring(1);

                }
            }
        }

        StringBuilder input2 = new StringBuilder();

        while (origInput.length() > 0) {

            if (Character.isDigit(origInput.charAt(origInput.length() - 1))) {

                input2.append(origInput.charAt(origInput.length() - 1));

                if (origInput.length() == 1) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 1);

                }

            } else if (origInput.endsWith("one")) {

                input2.append('1');

                if (origInput.length() == 3) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 3);

                }

            } else if (origInput.endsWith("two")) {

                input2.append('2');

                if (origInput.length() == 3) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 3);

                }

            } else if (origInput.endsWith("three")) {

                input2.append('3');

                if (origInput.length() == 5) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 5);

                }

            } else if (origInput.endsWith("four")) {

                input2.append('4');

                if (origInput.length() == 4) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 4);

                }

            } else if (origInput.endsWith("five")) {

                input2.append('5');

                if (origInput.length() == 4) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 4);

                }

            } else if (origInput.endsWith("six")) {

                input2.append('6');

                if (origInput.length() == 3) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 3);

                }

            } else if (origInput.endsWith("seven")) {

                input2.append('7');

                if (origInput.length() == 5) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 5);

                }

            } else if (origInput.endsWith("eight")) {

                input2.append('8');

                if (origInput.length() == 5) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 5);

                }

            } else if (origInput.endsWith("nine")) {

                input2.append('9');

                if (origInput.length() == 4) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 4);

                }

            } else {

                input2.append(origInput.charAt(origInput.length() - 1));

                if (origInput.length() == 1) {

                    origInput = "";

                } else {

                    origInput = origInput.substring(0, origInput.length() - 1);

                }
            }
        }

        System.out.println(input2);

        int value = 0;

        for (int i = 0; i < input1.length(); i++) {

            if (Character.isDigit(input1.charAt(i))) {

                value += (input1.charAt(i) - 48) * 10;
                break;

            }
        }

        for (int i = 0; i < input2.length(); i++) {

            if (Character.isDigit(input2.charAt(i))) {

                value += input2.charAt(i) - 48;
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

Day 2:

Part 1:

Part 2:
