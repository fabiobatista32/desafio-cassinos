import java.util.Scanner;

public class LuckyPlayer {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int n, k, m;

    while ((n = scanner.nextInt()) != 0) {
      k = scanner.nextInt();
      m = scanner.nextInt();

      Circle circle = new Circle();
      Node start = circle.fill(n);
      Node position1 = start;
      Node position2 = start.prev;

      int count = circle.count();
      Node selected1;
      Node selected2;

      while (count > 2) {
        selected1 = circle.select(position1, k, circle.CLOCKWISE);
        selected2 = circle.select(position2, m, circle.ANTICLOCKWISE);

        position1 = circle.nextPosition(selected1, selected2);
        position2 = circle.prevPosition(selected1, selected2);

        if (selected1 == selected2) {
          System.out.printf("%3d,", selected1.id);
        } else {
          System.out.printf("%3d%3d,", selected1.id, selected2.id);
          circle.delete(selected2);
        }
        circle.delete(selected1);
        count = circle.count();
      }

      if (count == 2) {
        selected1 = circle.select(position1, k, circle.CLOCKWISE);
        selected2 = circle.select(position2, m, circle.ANTICLOCKWISE);

        if (selected1 == selected2) {
          System.out.printf("%3d,%3d\n", selected1.id, selected1.next.id);
        } else {
          System.out.printf("%3d%3d\n", selected1.id, selected1.next.id);
        }
      } else {
        System.out.printf("%3d\n", start.id);
      }
    }

    scanner.close();
  }
}


