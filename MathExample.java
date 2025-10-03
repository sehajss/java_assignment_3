public class MathExample {
    public static void main(String[] args) {
        // Math.random() → returns a random double between 0.0 and 1.0
        double randomValue = Math.random();
        System.out.println("Random value: " + randomValue);

        // Math.abs() → returns the absolute value
        int negativeNumber = -25;
        int absoluteValue = Math.abs(negativeNumber);
        System.out.println("Absolute value of " + negativeNumber + " is " + absoluteValue);

        // Math.pow() → returns base raised to the power of exponent
        double base = 5;
        double exponent = 3;
        double powerResult = Math.pow(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is " + powerResult);
    }
}
