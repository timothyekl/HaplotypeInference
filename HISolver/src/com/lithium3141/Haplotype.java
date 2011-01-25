package com.lithium3141;

public class Haplotype extends SNPSequence {
	
	public Haplotype() {
		super();
	}
	public Haplotype(int[] snps) throws Exception {
		super(snps);
		this.normalize(1, true);
	}
	public Haplotype(Integer[] snps) throws Exception {
		super(snps);
		this.normalize(1, true);
	}
	
	public Genotype combineWith(Haplotype h) {
		if(h == null || h.snps.length != this.snps.length) {
			return null;
		}
		
		int[] snps = new int[h.snps.length];
		for(int i = 0; i < h.snps.length; i++) {
			snps[i] = this.snps[i] + h.snps[i];
		}
		return new Genotype(snps);
	}
	
}
