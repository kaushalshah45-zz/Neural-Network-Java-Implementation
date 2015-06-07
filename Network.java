import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Network {
	
	static NeuronLayer1 n1;
	static NeuronLayer1 n2;
	static NeuronLayer2 n3;
	static NeuronLayer2 n4;
	static NeuronLayer3 n5;
	static NeuronLayer1 bias1;
	static NeuronLayer2 bias2;
	static final double learning_rate = 0.05;
	static ArrayList<Double> errors = new ArrayList<Double>();
	
	public void initializeNetwork(){
		
	 n1 = new NeuronLayer1();
	 n2 = new NeuronLayer1();
	 n3 = new NeuronLayer2();
	 n4 = new NeuronLayer2();
	 n5 = new NeuronLayer3();
	 bias1 = new NeuronLayer1();
	 bias2 = new NeuronLayer2();
	 	n1.setWeight1(0.33);
		n1.setWeight2(0.42);
		n2.setWeight1(0.5);
		n2.setWeight2(-0.17);
		n3.setWeight1(0.35);
		n4.setWeight1(0.18);
		bias1.setWeight1(0.29);
		bias1.setWeight2(0.1);
		bias2.setWeight1(-0.43);
		bias1.setInput(1);
		bias1.setOutput(1);
		bias2.setInput(1);
		bias2.setOutput(1);
	}
	
	public static void main(String [] args){
		
		Network neural = new Network();
		neural.initializeNetwork();
		
		double correct_for_1epoch = 0;
		double correct_for_100epoch = 0;
		int lines_count = 0;
		
		//for 1 epoch
		try{
		FileReader fr = new FileReader("C:\\Progs\\MyCodes\\NeuralNetwork\\src\\dataset.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("C:\\Progs\\MyCodes\\NeuralNetwork\\src\\output1.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String line;
		
		while((line = br.readLine()) != null){
			
			lines_count++;
			
			String [] lines = line.split(" ");
			n1.setInput(Integer.parseInt(lines[0]));
			n1.computeOutput();
			n2.setInput(Integer.parseInt(lines[1]));
			n2.computeOutput();
			
			double layer1_output1 = n1.getOutput()*n1.getWeight1() + n2.getOutput()*n2.getWeight1() + bias1.getOutput()*bias1.getWeight1();
			double layer1_output2 = n1.getOutput()*n1.getWeight2() + n2.getOutput()*n2.getWeight2() + bias1.getOutput()*bias1.getWeight2();
				
			n3.setInput(layer1_output1);
			n3.computeOutput();
			n4.setInput(layer1_output2);
			n4.computeOutput();
			
			double output_layer2 = n3.getOutput()*n3.getWeight1() + n4.getOutput()*n4.getWeight1() + bias2.getOutput()*bias2.getWeight1();
			
			n5.setInput(output_layer2);
			n5.computeOutput();
			int c = 0;
			
			double final_output = n5.getOutput();
			
				if(final_output >= 0.5){
					c = 1;
					bw.write("1");
					bw.newLine();
				}
				else{
					bw.write("0");
					bw.newLine();
				}
			double target = Integer.parseInt(lines[2]);
			if(c == target)
				correct_for_1epoch++;
			double error = target - final_output;
			
			
			double val_for_weight1_layer2 = learning_rate * error * n3.getOutput() * n5.getOutput() * (1 - n5.getOutput());
			double val_for_weight2_layer2 = learning_rate * error * n4.getOutput() * n5.getOutput() * (1 - n5.getOutput());
			double val_for_bias2 = learning_rate * error * bias2.getOutput() * n5.getOutput() * (1 - n5.getOutput());
			bias2.setWeight1(bias2.getWeight1() + val_for_bias2);
			n3.setWeight1(n3.getWeight1() + val_for_weight1_layer2);
			n4.setWeight1(n4.getWeight1() + val_for_weight2_layer2);
					
			double val_for_weight1_layer1 = learning_rate * error * n1.getOutput() * n3.getOutput() * (1 - n3.getOutput());
			n1.setWeight1(n1.getWeight1() + val_for_weight1_layer1);
			double val_for_weight2_layer1 = learning_rate * error * n1.getOutput() * n4.getOutput() * (1 - n4.getOutput());
			n1.setWeight2(n1.getWeight2() + val_for_weight2_layer1);
			double val_for_weight3_layer1 = learning_rate * error * n2.getOutput() * n3.getOutput() * (1 - n3.getOutput());
			n2.setWeight1(n2.getWeight1() + val_for_weight3_layer1);
			double val_for_weight4_layer1 = learning_rate * error * n2.getOutput() * n4.getOutput() * (1 - n4.getOutput());
			n2.setWeight2(n2.getWeight2() + val_for_weight4_layer1);
			double val_for_bias11 = learning_rate * error * bias1.getOutput() * n3.getOutput() * (1 - n3.getOutput());
			bias1.setWeight1(bias1.getWeight1() + val_for_bias11);
			double val_for_bias12 = learning_rate * error * bias1.getOutput() * n4.getOutput() * (1 - n4.getOutput());
			bias1.setWeight2(bias1.getWeight1() + val_for_bias12);
		}
		bw.close();
		br.close();
		double acc = (correct_for_1epoch/lines_count) * 100;
		System.out.println("Accuracy for 1 epoch = " + acc);
		System.out.println("Final weights for node1  " + n1.getWeight1() + "  and " + n1.getWeight2());
		System.out.println("Final weights for node2  " + n2.getWeight1() + "  and  " + n2.getWeight2());
		System.out.println("Final weights for node3  " + n3.getWeight1());
		System.out.println("Final weights for node4  " + n4.getWeight1());
		System.out.println("Final weights for bias1  " + bias1.getWeight1() + "  and  " + bias1.getWeight2());
		System.out.println("Final weights for bias2  " + bias2.getWeight1());
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		//for 100 epoch
		for(int i = 0; i < 100; i++){
		try{
			FileReader fr = new FileReader("C:\\Progs\\MyCodes\\NeuralNetwork\\src\\dataset.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("C:\\Progs\\MyCodes\\NeuralNetwork\\src\\output2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String line;
			
			while((line = br.readLine()) != null){
				
				
				
				String [] lines = line.split(" ");
				n1.setInput(Integer.parseInt(lines[0]));
				n1.computeOutput();
				n2.setInput(Integer.parseInt(lines[1]));
				n2.computeOutput();
				
				double layer1_output1 = n1.getOutput()*n1.getWeight1() + n2.getOutput()*n2.getWeight1() + bias1.getOutput()*bias1.getWeight1();
				double layer1_output2 = n1.getOutput()*n1.getWeight2() + n2.getOutput()*n2.getWeight2() + bias1.getOutput()*bias1.getWeight2();
					
				n3.setInput(layer1_output1);
				n3.computeOutput();
				n4.setInput(layer1_output2);
				n4.computeOutput();
				
				double output_layer2 = n3.getOutput()*n3.getWeight1() + n4.getOutput()*n4.getWeight1() + bias2.getOutput()*bias2.getWeight1();
				
				n5.setInput(output_layer2);
				n5.computeOutput();
				int c = 0;
				
				double final_output = n5.getOutput();
				double target = Integer.parseInt(lines[2]);
				if(i == 99){
					if(final_output >= 0.5){
						c = 1;
						bw.write("1");
						bw.newLine();
					}
					else{
						bw.write("0");
						bw.newLine();
					}
					if(c == target)
						correct_for_100epoch++;
				}
				
				
				double error = target - final_output;
				
				
				double val_for_weight1_layer2 = learning_rate * error * n3.getOutput() * n5.getOutput() * (1 - n5.getOutput());
				double val_for_weight2_layer2 = learning_rate * error * n4.getOutput() * n5.getOutput() * (1 - n5.getOutput());
				double val_for_bias2 = learning_rate * error * bias2.getOutput() * n5.getOutput() * (1 - n5.getOutput());
				bias2.setWeight1(bias2.getWeight1() + val_for_bias2);
				n3.setWeight1(n3.getWeight1() + val_for_weight1_layer2);
				n4.setWeight1(n4.getWeight1() + val_for_weight2_layer2);
						
				double val_for_weight1_layer1 = learning_rate * error * n1.getOutput() * n3.getOutput() * (1 - n3.getOutput());
				n1.setWeight1(n1.getWeight1() + val_for_weight1_layer1);
				double val_for_weight2_layer1 = learning_rate * error * n1.getOutput() * n4.getOutput() * (1 - n4.getOutput());
				n1.setWeight2(n1.getWeight2() + val_for_weight2_layer1);
				double val_for_weight3_layer1 = learning_rate * error * n2.getOutput() * n3.getOutput() * (1 - n3.getOutput());
				n2.setWeight1(n2.getWeight1() + val_for_weight3_layer1);
				double val_for_weight4_layer1 = learning_rate * error * n2.getOutput() * n4.getOutput() * (1 - n4.getOutput());
				n2.setWeight2(n2.getWeight2() + val_for_weight4_layer1);
				double val_for_bias11 = learning_rate * error * bias1.getOutput() * n3.getOutput() * (1 - n3.getOutput());
				bias1.setWeight1(bias1.getWeight1() + val_for_bias11);
				double val_for_bias12 = learning_rate * error * bias1.getOutput() * n4.getOutput() * (1 - n4.getOutput());
				bias1.setWeight2(bias1.getWeight1() + val_for_bias12);
				
			}
			bw.close();
			br.close();
			
			if(i == 99){
			double acc = (correct_for_100epoch/lines_count) * 100;
			System.out.println("Accuracy for 100 epoch = " + acc);
			
			System.out.println("Final weights for node1  " + n1.getWeight1() + "  and " + n1.getWeight2());
			System.out.println("Final weights for node2  " + n2.getWeight1() + "  and  " + n2.getWeight2());
			System.out.println("Final weights for node3  " + n3.getWeight1());
			System.out.println("Final weights for node4  " + n4.getWeight1());
			System.out.println("Final weights for bias1  " + bias1.getWeight1() + "  and  " + bias1.getWeight2());
			System.out.println("Final weights for bias2  " + bias2.getWeight1());
			}
			
			}	
			catch(Exception e){
				e.printStackTrace();
			}
			
			}
		
		
		
	}

}
