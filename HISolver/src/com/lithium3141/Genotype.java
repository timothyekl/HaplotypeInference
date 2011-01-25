package com.lithium3141;

public class Genotype extends SNPSequence {

	public Genotype() {
		super();
	}
	public Genotype(int[] snps) {
		super(snps);
		try {
			this.normalize(2, false);
		} catch(Exception e) {
			System.err.println("Somehow generated an exception from a non-strict normalize method");
		}
	}
	public Genotype(Integer[] snps) {
		super(snps);
		try {
			this.normalize(2, false);
		} catch(Exception e) {
			System.err.println("Somehow generated an exception from a non-strict normalize method");
		}
	}

}
