package com.lithium3141;

public class SNPSequence {
	int[] snps;
	
	public SNPSequence() {
		this.snps = null;
	}
	
	public SNPSequence(int[] snps) {
		this.snps = snps;
	}
	
	public SNPSequence(Integer[] snps) {
		int[] converted = new int[snps.length];
		for(int i = 0; i < snps.length; i++) {
			converted[i] = snps[i].intValue();
		}
		this.snps = converted;
	}
	
	@Override
	public String toString() {
		if(this.snps.length == 0) {
			return "";
		}
		
		String ret = "" + this.snps[0];
		for(int i = 1; i < this.snps.length; i++) {
			ret += " " + this.snps[i];
		}
		return ret;
	}
}
