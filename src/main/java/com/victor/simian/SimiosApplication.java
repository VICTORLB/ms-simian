package com.victor.simian;

import java.util.Arrays;

public class SimiosApplication {

	private static final String DIRECTION_RIGHT = "R";
	private static final String DIRECTION_LEFT = "L";
	private static final int COUNT_FOR_SIMIOS = 4;

	private static Boolean isSimiosByRow(String[] dna) {

		System.out.println(">>>>>> isSimiosByRow START<");
		
		Boolean isSimios = Boolean.FALSE;
		for (int i = 0; i < dna.length; i++) {
//			System.out.println(">>>>>> post1:["+dna[i]+"]<<");
			
			char item[] = dna[i].toCharArray();
//			System.out.println(">>>>post1 to char[]...: "+Arrays.toString(item));
			int count = 1;
			int countSimios = COUNT_FOR_SIMIOS;
			for (int j = 0; j < item.length-1; j++) {
				char atual = item[j];
				char compare = item[j+1];
				if (atual == compare) {
					count++;
					if (count == countSimios) {
						System.out.println(">>Simios by Row > "+Arrays.toString(item));
						isSimios = Boolean.TRUE;
					}
				}else if (count > 1) count=1;
				
			}
		}
		System.out.println(">>>>>> isSimiosByRow ["+isSimios+"] DONE <");
		return isSimios;
		
	}
	
	private static Boolean isSimiusByColumn(char[][] tableDna) {
		System.out.println(">>>>>> isSimiusByColumn START<");
		Boolean isSimios = Boolean.FALSE;
		for (int col=0;col<6;col++) {
//			System.out.println(">>>>>> Reading Column ["+col+"]<");
			int count = 1;
			int countSimios = COUNT_FOR_SIMIOS;
			for (int row=0;row<5;row++) {
//				if(col==4)System.out.println("Coluna["+col+"] Linha["+row+"] value ["+tableDna[row][col]+"] count["+count+"]");
				char atual = tableDna[row][col];
				char compare = tableDna[row+1][col];
//				if(col==4)System.out.println("atual["+atual+"] compare["+compare+"]");
				if (atual == compare) {
					count++;
//					if(col==4)System.out.println("igual - count["+count+"]\n");
					if (count >= countSimios) {
						System.out.println(">>>>> Simios by Column > ["+col+"], count:["+count+"]");
						isSimios = Boolean.TRUE;
						count=1;
					}

				}else if (count > 1) count=1;
				
				
			}
			
		}
		System.out.println(">>>>>> isSimiusByColumn ["+isSimios+"] DONE <");
		return isSimios;
	}
	
	private static Boolean isSimiusByDiagonally(char[][] tableDna, String direction) {
		System.out.println("START - isSimiusByDiagonally > direction["+direction+"]");
		Boolean isSimios = Boolean.FALSE;
		
		int readAtColumn = 5;
		int readAtRow = 2;
		int startAtColumn = 0;
		int countSimios = COUNT_FOR_SIMIOS;
		
		//if (toUpOrDown.equals(DIRECTION_DOWN)) readAtRow = 2;
		if (direction.equals(DIRECTION_LEFT) ) startAtColumn = 3;
		
		if (direction.equals(DIRECTION_RIGHT) ) { 
			startAtColumn = 0 ;
			readAtColumn = 2;	
		}

		for (int col=startAtColumn; col <= readAtColumn; col++) {
			int count = 1;
			int rowCompare = 0;
			int columnCompare=0;
			for (int row=0;row<=readAtRow;row++) {
				char atual = tableDna[row][col];
				char compare = 0; 
				rowCompare = row+1;
				columnCompare = (direction.equals(DIRECTION_RIGHT)) ? col+1 : col-1;
				compare = tableDna[rowCompare][columnCompare];
				if (atual == compare) {
					count++;
					rowCompare = rowCompare+1;
					columnCompare = (direction.equals(DIRECTION_RIGHT)) ? columnCompare+1 : columnCompare-1;
					compare = tableDna[rowCompare][columnCompare];
					if (atual ==compare) {
						count++;
						rowCompare = rowCompare+1;
						columnCompare = (direction.equals(DIRECTION_RIGHT)) ? columnCompare+1 : columnCompare-1;
						compare = tableDna[rowCompare][columnCompare];
						if (atual ==compare) {
							count++;
							if (count >= countSimios) {
								System.out.println(">>> Simios! by Diagonally > Row:["+row+"], Col["+col+"]<<<\n");
								isSimios = Boolean.TRUE;
								count=1;
							}
						}
					}else if (count > 1) count=1;
				}else if (count > 1) count=1;
			}
		}
		System.out.println("DONE - Simios > ["+isSimios+"] direction["+direction+"]");
		return isSimios;
	}
	
	private static char[][] convertToTable(String[] dna){
		char[][] table = new char[6][6];
		for (int i = 0; i < dna.length; i++) {
			char item[] = dna[i].toCharArray();
			
			System.out.println("table, item: "+Arrays.toString(item));
			table[i][0] = item[0];
			table[i][1] = item[1];
			table[i][2] = item[2];
			table[i][3] = item[3];
			table[i][4] = item[4];
			table[i][5] = item[5];
		}
		return table;
	}
	
	
	public static void main(String[] args) {
		//toLeft
		String[] dna = {  "CTGAGA", "CTATGC", "TATTGT", "AGTGGG", "CTGTTA", "TGTCTG"};
		//toRigth
//		String[] dna = {  "CAGAGA", "TCTTGC", "CGCTGT", "ACGCTG", "CTCGTT", "TGTCGG"};
		
//		String[] dna = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };
		char[][] table = convertToTable(dna);
		Boolean isSimiusByDiagonallyR = isSimiusByDiagonally(table, DIRECTION_RIGHT);
		Boolean isSimiusByDiagonallyL= isSimiusByDiagonally(table, DIRECTION_LEFT);
		Boolean isSimiosByRow = isSimiosByRow(dna);
		Boolean isSimiusByColumn = isSimiusByColumn(table);
		
		System.out.println(">>>> return Simios >\n by row["+ isSimiosByRow+"] "
				+ "\nby column["+isSimiusByColumn+"], "
				+ "\nby byDiagonallyRigth["+isSimiusByDiagonallyR+"], "
				+ "\nby byDiagonallyLeft["+isSimiusByDiagonallyL+"], "
				);
				
		/*
		 	{
      		"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
			}
		//A,T,C,G
		//String[] human = { "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" }; 
		//String[] simios = { "CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG" };
		  
		 * */
		
	}


}
