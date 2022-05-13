import java.util.Scanner;
public class StepTracker {
    Converter converter = new Converter();
    int[][] monthToData;
    int goalSteps = 10000; // цель на день по умолчанию.
    Scanner scanner = new Scanner(System.in);


    public StepTracker() {
        monthToData = new int[12][30];
    }
    public void saveSteps() {
        System.out.println("За какой месяц Вы хотите ввести шаги?");
        System.out.println("Введите данные. Формат ввода: Январь это 0, февраль - 1 и т.п.");//в соответствии с ТЗ. В своей версии попробую исправить
        int month = scanner.nextInt(); // если сделать scanner.nextInt() - 1 то можно по идеи сделать правильный отсчёт месяцев
        if (month > 11) {
            System.out.println("В нашем приложении крайний месяц - 11.");
        } else {
            if (month < 0) {
                System.out.println("В нашем приложении нет отрицательных значений:)");
            } else {
                System.out.println("За какой день внести шаги?");
                System.out.println("Введите нужный день месяца. Формат ввода: формат: 1 - 1 число (Ваше число))");
                int day = scanner.nextInt();
                if (day > 30) {
                    System.out.println("Кол-во дней не больше 30!");
                } else {
                    if (day < 0) {
                        System.out.println("Кол-во дней отрицательным не бывает:3");
                    } else {
                        System.out.println("Сколько шагов вы сделали за этот день?");
                        int steps = scanner.nextInt();
                        if (steps < 0) {
                            System.out.println("Отрицательного значения шагов не бывает! Любое усилие это + :)");
                        } else {
                            monthToData[month][day] = steps;
                        }
                    }
                }
            }
        }
    }


    public int changeGoalSteps() {
            System.out.println("Текущая цель: " + goalSteps + ".");
            System.out.println("Введите новую цель: ");
            int newGoalSteps = scanner.nextInt();
            if (newGoalSteps < 0) {
                System.out.println("Не бывает отрицательных значений, каждый шаг это большой плюс!");
            } else {
                goalSteps = newGoalSteps;
                System.out.println("Ваша новая цель: " + goalSteps + "!");
            }
            return goalSteps;
    }

    public void statsMonth () {
        System.out.println("Введите нужный Вам месяц. (от 0 до 11)");
        int month = scanner.nextInt();
        int sumStepsInMonth = 0; // сумма всех шагов
        int maxStepsInMonth = 0; // макс. шагов за месяц
        int meanSteps = 0; // среднее кол-во шагов
        int maxSeriesDay = 0; // макс серия
        int beastSteps = 0; //  лучшая серия
        for (int i = 0; i < monthToData[month].length; i++) {
            sumStepsInMonth = sumStepsInMonth + monthToData[month][i]; // всего шагов за месяц
            if (monthToData[month][i] > maxStepsInMonth) { // макс. число шагов за один день в месяце
                maxStepsInMonth = monthToData[month][i];
            }
            meanSteps = sumStepsInMonth / monthToData[month].length; // среднее число шагов всего
            if (monthToData[month][i] >= goalSteps) { // лучшая серия шагов за месяц
                beastSteps++;
                if (beastSteps > maxSeriesDay) {
                    maxSeriesDay = beastSteps;
                }
            } else {
                beastSteps = 0;
            }
        }
            System.out.println("Общее количество шагов за месяц: " + sumStepsInMonth + ".");
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsInMonth + ".");
            System.out.println("Среднее количество шагов: " + meanSteps + ".");
            System.out.println("Пройденная дистанция (в км): " + converter.stepsToKm(sumStepsInMonth) + ".");
            System.out.println("Количество сожжённых килокалорий: " + converter.stepsToKcalories(sumStepsInMonth) + ".");
            System.out.println("Лучшая серия*: " + beastSteps + ".");
            System.out.println("*-максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.");
        }
    }
