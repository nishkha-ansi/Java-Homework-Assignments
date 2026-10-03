import java.util.*;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract boolean supportsSaver();

    double getUnits() {
        return getPower() * hours / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    boolean supportsSaver() {
        return false;
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    boolean supportsSaver() {
        return false;
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class Problem5_HomeApplianceEnergyReport {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();

                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE"))
                appliance = new Fridge(hours);
            else if (type.equals("AC"))
                appliance = new AC(hours);
            else if (type.equals("TV"))
                appliance = new TV(hours);
            else
                appliance = new Washer(hours);

            if (saver && !appliance.supportsSaver()) {
                System.out.println(
                        type + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.getUnits();

            if (saver) {
                units *= 0.75;
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}