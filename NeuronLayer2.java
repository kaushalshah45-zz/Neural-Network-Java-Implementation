
public class NeuronLayer2 {
	
	private double weight1;
	
	private double input;	
	private double output;
	
	
	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}

	public double getInput() {
		return input;
	}

	public void setInput(double input) {
		this.input = input;
	}

	public double getWeight1() {
		return weight1;
	}

	public void setWeight1(double weight1) {
		this.weight1 = weight1;
	}

	
	
	public NeuronLayer2(){
		
		weight1 = Math.random();
		if(weight1 > 0.5)
			weight1 = -weight1;
	}
	
	private static double sigmoid(double x)
	{
	    return 1 / (1 + Math.exp(-x));
	}
	
	public void computeOutput(){
		
		double val1 = NeuronLayer2.sigmoid(input);
		output = val1;
	}
	
	

}
