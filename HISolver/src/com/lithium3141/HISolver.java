package com.lithium3141;

import java.util.List;

public class HISolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HIDataReader dr = new HIDataReader("../HapData.txt");
		List<Genotype> genotypes = dr.readData();
		
		for(Genotype g : genotypes) {
			System.out.println(g);
		}
	}

}
