
public class NeuronLayer3 {
	
	private double output;
	private double input;
		
	public double getInput() {
		return input;
	}

	public void setInput(double input) {
		this.input = input;
	}

	
	
	public NeuronLayer3(){
		
	}
	
	private static double sigmoid(double x)
	{
	    return 1 / (1 + Math.exp(-x));
	}
	
	public void computeOutput(){
		
		output = NeuronLayer3.sigmoid(input);
	}
	
	public double getOutput(){
		
		return output;
	}

}
