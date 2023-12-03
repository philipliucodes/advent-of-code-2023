import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day3Part2 {

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
