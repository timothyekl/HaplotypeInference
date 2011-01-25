package com.lithium3141;

import java.util.ArrayList;
import java.util.List;

public class HISolver {
	
	public static int countOccurrencesAt(int snp, int pos, List<? extends SNPSequence> sequences) {
		if(sequences.size() == 0) {
			return 0;
		}
		
		int count = 0;
		for(SNPSequence seq : sequences) {
			if(seq.snps[pos] == snp) {
				count++;
			}
		}
		return count;
	}
	
	public static int countOccurrences(int snp, List<? extends SNPSequence> sequences) {
		if(sequences.size() == 0) {
			return 0;
		}
		
		int count = 0;
		for(SNPSequence seq : sequences) {
			for(int i = 0; i < seq.snps.length; i++) {
				if(seq.snps[i] == snp) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Find the haplotype which is likely to have the most in common
	 * with all the provided genotypes.
	 * 
	 * @param genotypes List of genotypes to check
	 * @return The most common haplotype
	 */
	public static Haplotype mostCommon(List<Genotype> genotypes) throws Exception {
		Haplotype best = null;
		
		if(genotypes.size() != 0) {
			int[] snps = new int[genotypes.get(0).snps.length];
			
			for(Genotype genotype : genotypes) {
				for(int i = 0; i < genotype.snps.length; i++) {
					snps[i] += genotype.snps[i];
				}
			}
			
			best = new Haplotype(snps);
		}
		
		return best;
	}
	
	/**
	 * Find whether the given set of haplotypes can create the given set
	 * of genotypes by brute force.
	 * @param haplotypes The set of haplotypes to check
	 * @param genotypes The set of genotypes to check
	 * @return Whether haplotypes can generate genotypes
	 */
	public static boolean generatesAll(List<Haplotype> haplotypes, List<Genotype> genotypes) {
		List<Genotype> generated = new ArrayList<Genotype>();
		for(Genotype genotype : genotypes) {
			for(int i = 0; i < haplotypes.size(); i++) {
				for(int j = i + 1; j < haplotypes.size(); j++) {
					if(haplotypes.get(i).combineWith(haplotypes.get(j)).equals(genotype)) {
						generated.add(genotype);
						continue;
					}
				}
			}
		}
		return generated.containsAll(genotypes);
	}
	
	public static void main(String[] args) throws Exception {
		HIDataReader dr = new HIDataReader("../HapData.txt");
		List<Genotype> genotypes = dr.readData();
		
		Haplotype trent = mostCommon(genotypes);
		System.out.println("Initial common haplotype: " + trent);
		
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(trent);
		
		while(!generatesAll(haplotypes, genotypes)) {
			break;
		}
	}

}
