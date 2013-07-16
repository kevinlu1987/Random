package org.mc2.randompoint;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) {

		int num = 20000000;
		double[] seeds = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		OutputStream osObservation = null;
		OutputStream osCluster = null;
		
		try {
			osObservation = new FileOutputStream("/home/lukuen/observations_"+num+".txt");
			osCluster = new FileOutputStream("/home/lukuen/cluster_"+seeds.length+".txt");
			
			//generating cluster
			for (int i=0; i<seeds.length; i++) {
				osCluster.write(("" + i + "," + i + " " + seeds[i] + "," + seeds[i] + "\n").getBytes());
			}
			
			
			// generating observations from seeds
			for (int i = 1; i <= num; i++) {

				double r = Math.random();
				int index = ((int)(r*10)) % 10;
				String point = "";
				double positon = (seeds[index]+r);
				point = "" + (positon) + "," + (positon) + "\n";
				
				osObservation.write(point.getBytes());
				if (i%100000 == 0) {
					System.out.println("write " + i + " points.");
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				osObservation.close();
				osCluster.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
