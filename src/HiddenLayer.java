package src;

/**
 * Created by Matt on 2015-06-07.
 */
class HiddenLayer extends Layer {
    //==================================================================================================================
    // Variables
    //==================================================================================================================
    private double weight1;

    //==================================================================================================================
    // Methods
    //==================================================================================================================

    public HiddenLayer() {
        weight1 = Math.random();

        if(weight1 > 0.5) {
            weight1 = -weight1;
        } // END HiddenLayer()
    } // END HiddenLayer()

    public double getWeight1() {
        return this.weight1;
    } // END getWeight1()

    public void setWeight1(double weight1) {
        this.weight1 = weight1;
    } // END setWeight1()

    private static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    } // END sigmoid()

    @Override
    public void computeOutput() {
        output = sigmoid(input);
    } // END computeOutput()
} // END HiddenLayer.java
