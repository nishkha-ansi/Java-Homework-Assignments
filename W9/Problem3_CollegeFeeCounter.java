import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getFee();
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double getFee() {
        return 20000 + 12000;
    }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR"))
                student = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                student = new Hosteller(name);
            else
                student = new Scholar(name);

            double fee = student.getFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}