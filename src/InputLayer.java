package src;

/**
 * Created by Matt on 2015-06-07.
 */
class InputLayer extends Layer {

    //==================================================================================================================
    // Variables
    //==================================================================================================================
    private double weight1;
    private double weight2;

    //==================================================================================================================
    // Methods
    //==================================================================================================================

    public InputLayer() {
        weight1 = Math.random();
        weight2 = Math.random();

        if(weight1 > 0.5) {
            weight1 = -weight1;
        } // END if

        if(weight2 < 0.5) {
            weight2 = -weight2;
        } // END if
    } // END InputLayer()

    public double getWeight1() {
        return this.weight1;
    } // END getWeight1()

    public void setWeight1(double weight1) {
        this.weight1 = weight1;
    } // END setWeight1()

    public double getWeight2() {
        return this.weight2;
    } // END getWeight2()

    public void setWeight2(double weight2) {
        this.weight2 = weight2;
    } // END setWeight2()
} // END InputLayer.java
