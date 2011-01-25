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
	
	/**
	 * Change this SNP sequence's values to be "normalized", i.e. contain
	 * only the given multiplier value or its negative. May also contain
	 * zero values if the strict argument is false.
	 * 
	 * @param multiplier The legal value for this SNP sequence.
	 * @param strict Whether to allow zero in the sequence; a false value
	 * implies zeros are allowed.
	 */
	public void normalize(int multiplier, boolean strict) throws Exception {
		for(int i = 0; i < this.snps.length; i++) {
			if(this.snps[i] != 0) {
				this.snps[i] = multiplier * (this.snps[i] / Math.abs(this.snps[i]));
			} else {
				if(strict) {
					throw new Exception("May not have SNP values of zero in a strict SNP sequence.");
				}
			}
		}
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
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof SNPSequence)) {
			return false;
		}
		
		SNPSequence s = (SNPSequence) o;
		if(s.snps.length != this.snps.length) {
			return false;
		}
		
		for(int i = 0; i < s.snps.length; i++) {
			if(s.snps[i] != this.snps[i]) {
				return false;
			}
		}
		
		return true;
	}
}
