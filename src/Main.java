import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stepTracker.saveSteps();
                    break;
                case 2:
                    stepTracker.statsMonth();
                    break;
                case 3:
                    stepTracker.changeGoalSteps();
                    break;
                case 4:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Такой команды нет, попробуйте снова.");
                    break;
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
