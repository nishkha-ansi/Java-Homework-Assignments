import java.util.*;

abstract class Seat {
    int count;

    Seat(int count) {
        this.count = count;
    }

    abstract double getPrice();
    abstract String getType();

    double getAmount() {
        return count * getPrice() + count * 20;
    }
}

class Regular extends Seat {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getType() {
        return "REGULAR";
    }
}

class Premium extends Seat {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getType() {
        return "PREMIUM";
    }
}

class Recliner extends Seat {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getType() {
        return "RECLINER";
    }
}

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Seat seat;

            if (type.equals("REGULAR"))
                seat = new Regular(count);
            else if (type.equals("PREMIUM"))
                seat = new Premium(count);
            else
                seat = new Recliner(count);

            double amount = seat.getAmount();

            System.out.printf("%s: %.2f%n",
                    seat.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}