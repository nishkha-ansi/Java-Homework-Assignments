import java.util.*;

abstract class Parcel {
    double weight;
    double value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();
    abstract double getInsurance();
    abstract String getType();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }

    double getInsurance() {
        return 0;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    double getInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    double getInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD"))
                parcel = new StandardParcel(weight, value);
            else if (type.equals("EXPRESS"))
                parcel = new ExpressParcel(weight, value);
            else
                parcel = new FragileParcel(weight, value);

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}