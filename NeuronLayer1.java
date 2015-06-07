
public class NeuronLayer1 {
	
	private double input;
	
	private double weight1;
	private double weight2;
	private double output;
	
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
	
	public double getWeight2() {
		return weight2;
	}

	public void setWeight2(double weight2) {
		this.weight2 = weight2;
	}

	
	
	public NeuronLayer1(){
		
		weight1 = Math.random();
		weight2 = Math.random();
		
		if(weight1 > 0.5)
			weight1 = -weight1;
		if(weight2 < 0.5)
			weight2 = -weight2;
	}
	
	public void computeOutput(){
		
		output = input;
	}
	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}
	
	
}
