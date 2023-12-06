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
