import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract boolean offersNightService();

    double calculateFare() {
        return Math.max(100, km * getRate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    boolean offersNightService() {
        return false;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean offersNightService() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean offersNightService() {
        return true;
    }
}

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI"))
                cab = new Mini(km);
            else if (type.equals("SEDAN"))
                cab = new Sedan(km);
            else
                cab = new SUV(km);

            if (time.equals("NIGHT") && !cab.offersNightService()) {
                System.out.println(
                        type + ": night service not available"
                );
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}