public class PerceptronLogic {
    public static void main(String[] args) {
        // Define the 2D array representing the permutations of two operands
        float[][] data = {
            {0.00f, 0.00f},
            {1.00f, 0.00f},
            {0.00f, 1.00f},
            {1.00f, 1.00f}
        };

        // Logical AND operation
        System.out.println("Training for AND operation:");
        float[] expectedAnd = {0.00f, 0.00f, 0.00f, 1.00f};
        Perceptron perceptronAnd = new Perceptron(2);
        perceptronAnd.train(data, expectedAnd, 10000);

        for (int row = 0; row < data.length; row++) {
            int result = perceptronAnd.activate(data[row]);
            System.out.println("AND Result " + row + ": " + result);
        }

        // Logical OR operation
        System.out.println("\nTraining for OR operation:");
        float[] expectedOr = {0.00f, 1.00f, 1.00f, 1.00f};
        Perceptron perceptronOr = new Perceptron(2);
        perceptronOr.train(data, expectedOr, 10000);
        
        for (int row = 0; row < data.length; row++) {
            int result = perceptronOr.activate(data[row]);
            System.out.println("OR Result " + row + ": " + result);
        }
    }
}