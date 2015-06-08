package src;

/**
 * Created by Matt on 2015-06-07.
 */
class OutputLayer extends Layer {
    //==================================================================================================================
    // Methods
    //==================================================================================================================
    public OutputLayer() {} // END OutputLayer()

    private static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    } // END sigmoid()

    @Override
    public void computeOutput() {
        output = sigmoid(input);
    } // END computeOutput()
} // END OutputLayer.java
