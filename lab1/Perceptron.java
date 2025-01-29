public class Perceptron {
    private float[] weights;
    private float threshold = 0.2f;
    private float learningRate = 0.1f;

    // Initialize perceptron with random weights
    public Perceptron(int inputs) {
        this.weights = new float[inputs];
        for (int i = 0; i < inputs; i++) {
            weights[i] = (float) (Math.random() * 2 - 1);
        }
        System.out.println("Initial weights: " + weights[0] + ", " + weights[1]);
    }

    // Train the perceptron using given data and expected outputs
    public void train(float[][] data, float[] expected, int epochs) {
        int epoch;
        for (epoch = 0; epoch < epochs; epoch++) {
            boolean errorFlag = false;
            for (int i = 0; i < data.length; i++) {
                int output = activate(data[i]);
                float error = expected[i] - output;
                if (error != 0) errorFlag = true;
                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * data[i][j];
                }
            }
            if (!errorFlag) break; // Stop early if no errors
        }
        System.out.println("Training complete in " + epoch + " epochs.");
        System.out.println("Final weights: " + weights[0] + ", " + weights[1]);
    }

    // Compute perceptron activation using weighted sum and threshold
    public int activate(float[] inputs) {
        float sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sum >= threshold ? 1 : 0;
    }
}