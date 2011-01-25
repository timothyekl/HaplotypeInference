package com.lithium3141;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HIDataReader {
	String filePath = null;
	BufferedReader inReader = null;
	
	public HIDataReader(String path) {
		this.filePath = path;
		try {
			this.inReader = new BufferedReader(new FileReader(this.filePath));
		} catch (FileNotFoundException e) {
			System.err.println("Could not find file: " + this.filePath);
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public List<Genotype> readData() throws Exception {
		String line = null;
		ArrayList<Genotype> list = new ArrayList<Genotype>();
		
		try {
			while((line = this.inReader.readLine()) != null) {
				String[] parts = line.split(" ");
				int[] snps = new int[parts.length];
				for(int i = 0; i < parts.length; i++) {
					int snp = (new Integer(parts[i])).intValue();
					snps[i] = snp;
				}
				list.add(new Genotype(snps));
			}
		} catch (IOException e) {
			System.err.println("Could not read line from file: " + this.filePath);
			e.printStackTrace();
		}
		
		return list;
	}
}
