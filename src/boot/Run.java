package boot;

import java.io.IOException;

import algorithms.demo.Demo;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo=new Demo();
		try {
			demo.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
