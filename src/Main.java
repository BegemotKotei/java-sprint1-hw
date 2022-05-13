import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.saveSteps();
            } else if (command == 2) {
                stepTracker.statsMonth();

            } else if (command == 3) {
                stepTracker.changeGoalSteps();

            } else if (command == 4) {
                System.out.println("Выход.");
                break;

            } else {
                System.out.println("Такой команды нет, попробуйте снова.");
            }
        }
    }

        private static void printMenu() {
            System.out.println("1. Ввести количество шагов за определённый день;");
            System.out.println("2. Напечатать статистику за определённый месяц;");
            System.out.println("3. Изменить цель по количеству шагов в день;");
            System.out.println("4. Выйти из приложения.");
        }
}
