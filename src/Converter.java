public class Converter {
    double oneStepsInKm = 0.00075;
    double oneStepsCalories = 0.05;

    final public double stepsToKm(int sumStepsInMonth) {
        return sumStepsInMonth * oneStepsInKm;
    }
    final public double stepsToKcalories(int sumStepsInMonth) {
        return sumStepsInMonth * oneStepsCalories;
    }

}
