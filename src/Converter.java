public class Converter {
    double oneStepsInKm = 0.00075;
    double oneStepsCalories = 0.5;

    public double stepsToKm(int sumStepsInMonth) {
        return sumStepsInMonth * oneStepsInKm;
    }

    public double stepsToKcalories(int sumStepsInMonth) {
        return sumStepsInMonth * oneStepsCalories;
    }

}
