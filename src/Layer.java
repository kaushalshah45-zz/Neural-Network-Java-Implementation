package src;

/**
 * Created by Matt on 2015-06-07.
 */
class Layer {
    //==================================================================================================================
    // Variables
    //==================================================================================================================
    double input;
    double output;

    //==================================================================================================================
    // Methods
    //==================================================================================================================

    protected double getInput() {
        return input;
    } // END getInput()

    void setInput(double input) {
        this.input = input;
    } // END setInput()

    double getOutput() {
        return output;
    } // END getOutput()

    void setOutput() {
        this.output = input;
    } // END setOutput()

    void computeOutput() {
        setOutput();
    } // END computeOutput()
} // END Layer.java
