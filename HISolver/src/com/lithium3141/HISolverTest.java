package com.lithium3141;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HISolverTest {

	@Test
	public void testGeneratesAll_Empty() {
		List<Genotype> genotypes = new ArrayList<Genotype>();
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		
		assertTrue(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_True_Positive() throws Exception {
		int hsnps[] = {1};
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(new Haplotype(hsnps));
		haplotypes.add(new Haplotype(hsnps));
		
		int gsnps[] = {2};
		List<Genotype> genotypes = new ArrayList<Genotype>();
		genotypes.add(new Genotype(gsnps));
		
		assertTrue(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_True_Negative() throws Exception {
		int hsnps[] = {-1};
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(new Haplotype(hsnps));
		haplotypes.add(new Haplotype(hsnps));
		
		int gsnps[] = {-2};
		List<Genotype> genotypes = new ArrayList<Genotype>();
		genotypes.add(new Genotype(gsnps));
		
		assertTrue(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_True_Zero() throws Exception {
		int hsnps1[] = {1};
		int hsnps2[] = {-1};
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(new Haplotype(hsnps1));
		haplotypes.add(new Haplotype(hsnps2));
		
		int gsnps[] = {0};
		List<Genotype> genotypes = new ArrayList<Genotype>();
		genotypes.add(new Genotype(gsnps));
		
		assertTrue(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_False_Positive() throws Exception {
		int hsnps[] = {1};
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(new Haplotype(hsnps));
		haplotypes.add(new Haplotype(hsnps));
		
		int gsnps[] = {-2};
		List<Genotype> genotypes = new ArrayList<Genotype>();
		genotypes.add(new Genotype(gsnps));
		
		assertFalse(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_False_Negative() throws Exception {
		int hsnps[] = {-1};
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		haplotypes.add(new Haplotype(hsnps));
		haplotypes.add(new Haplotype(hsnps));
		
		int gsnps[] = {2};
		List<Genotype> genotypes = new ArrayList<Genotype>();
		genotypes.add(new Genotype(gsnps));
		
		assertFalse(HISolver.generatesAll(haplotypes, genotypes));
	}
	
	@Test
	public void testGeneratesAll_OneSNP_TrueRange() throws Exception {
		int hsnps[][] = { {1}, {1}, {-1}, {-1} };
		List<Haplotype> haplotypes = new ArrayList<Haplotype>();
		for(int i = 0; i < hsnps.length; i++) {
			haplotypes.add(new Haplotype(hsnps[i]));
		}
		
		int gsnps[][] = { {2}, {0}, {-2} };
		List<Genotype> genotypes = new ArrayList<Genotype>();
		for(int i = 0; i < gsnps.length; i++) {
			genotypes.add(new Genotype(gsnps[i]));
		}
		
		assertTrue(HISolver.generatesAll(haplotypes, genotypes));
	}

}
