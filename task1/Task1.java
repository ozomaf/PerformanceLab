public class Task1 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        System.out.println(calculateResult(n, m));
    }

    private static String calculateResult(int n,
                                          int m) {
        StringBuilder result = new StringBuilder();
        int currentIndex = 0;

        do {
            result.append(currentIndex + 1);
            currentIndex = (currentIndex + m - 1) % n;
        } while (currentIndex != 0);

        return result.toString();
    }

}