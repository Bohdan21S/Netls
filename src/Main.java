import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть координати точок квадрату:");
        System.out.print("x1, y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("x2, y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.print("x3, y3: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        System.out.print("x4, y4: ");
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();

        System.out.println("Введіть координати точки:");
        System.out.print("px, py: ");
        double px = scanner.nextDouble();
        double py = scanner.nextDouble();

        boolean inside = isPointInSquare(x1, y1, x2, y2, x3, y3, x4, y4, px, py);

        if (inside) {
            System.out.println("Точка всередині квадрата");
        } else {
            System.out.println("Точка поза квадратом");
        }
    }

    public static boolean isPointInSquare(double x1, double y1, double x2, double y2,
                                          double x3, double y3, double x4, double y4,
                                          double px, double py) {
        double squareArea = area(x1, y1, x2, y2, x3, y3) + area(x1, y1, x3, y3, x4, y4);

        double area1 = area(px, py, x1, y1, x2, y2);
        double area2 = area(px, py, x2, y2, x3, y3);
        double area3 = area(px, py, x3, y3, x4, y4);
        double area4 = area(px, py, x4, y4, x1, y1);

        double totalArea = area1 + area2 + area3 + area4;

        return Math.abs(totalArea - squareArea) < 1e-6;
    }
    public static double area(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
}
