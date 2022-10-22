import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent (double a, double y, int d) {

        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return doCalculations(pay, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {

        return doCalculations(amount + amount * yearRate * depositPeriod, 2);
    }

    double doCalculations(double value,int places) {

        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    void printMenu() {
        int period;
        int command;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада: \n" +
                "1 - Вклад с обычным процентом,\n " +
                "2 - Вклад с капитализацией:");
        command = scanner.nextInt();

        double outDoubleVar = 0;
        if (command ==1) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        } else if (command == 2) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period +
                " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
