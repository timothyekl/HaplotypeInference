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
	
	/**
	 * Return the other parent Haplotype that combines with the given haplotype
	 * to form this Genotype, or null if no such haplotype exists.
	 * @param haplotype The Haplotype to pair with.
	 * @return A pair for the given Haplotype that forms this Genotype, or null
	 * if no such pair exists.
	 */
	public Haplotype parentPairOf(Haplotype haplotype) {
		SNPSequence intermediate = this.subtract(haplotype);
		if(intermediate == null) {
			return null;
		}
		
		for(int i = 0; i < intermediate.snps.length; i++) {
			if(intermediate.snps[i] != 1 && intermediate.snps[i] != -1) {
				return null;
			}
		}
		
		try {
			return new Haplotype(intermediate.snps);
		} catch(Exception e) {
			return null;
		}
	}

}
