import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws Exception {
        Circle circle = readCircle(args[0]);
        List<Point> points = readPoints(args[1]);

        for (Point point : points) {
            int position = calculatePointPosition(circle, point);
            System.out.println(position);
        }
    }

    private static int calculatePointPosition(Circle circle,
                                              Point point) {
        float circleEquation = (float) (Math.pow((point.x - circle.centreX), 2) +
                Math.pow((point.y - circle.centreY), 2));
        float sqrtRadios = circle.radios * circle.radios;

        if (circleEquation < sqrtRadios) {
            return 1;
        } else if (circleEquation > sqrtRadios) {
            return 2;
        } else {
            return 0;
        }
    }

    private static Circle readCircle(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] coordinates = reader.readLine().split(" ");
            float centreX = Float.parseFloat(coordinates[0]);
            float centreY = Float.parseFloat(coordinates[1]);
            float radios = Float.parseFloat(reader.readLine());
            return new Circle(centreX, centreY, radios);
        }
    }

    private static List<Point> readPoints(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Point> points = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split(" ");
                float x = Float.parseFloat(coordinates[0]);
                float y = Float.parseFloat(coordinates[1]);
                points.add(new Point(x, y));

            }
            return points;
        }
    }

    private static class Circle {
        private final float centreX;
        private final float centreY;
        private final float radios;

        public Circle(float centreX, float centreY, float radios) {
            this.centreX = centreX;
            this.centreY = centreY;
            this.radios = radios;
        }
    }

    private static class Point {
        private final float x;
        private final float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

}