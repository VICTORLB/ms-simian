package com.victor.simian.util;

import java.util.Arrays;

import com.victor.simian.constants.DnaConstants;

public class DnaUtil {

	public static Boolean isSimian(String[] dna) {

		Boolean isSimian = Boolean.FALSE;

		if (isSimiosRow(dna)) return Boolean.TRUE;

		char[][] table = convertToTable(dna);

		if (isSimiusColumn(table)) return Boolean.TRUE;

		if (isSimiusDiagonally(table, DnaConstants.DIRECTION_RIGHT)) return Boolean.TRUE;

		if (isSimiusDiagonally(table, DnaConstants.DIRECTION_LEFT)) return Boolean.TRUE;

		return isSimian;
	}

	public static Boolean isSimianComplete(String[] dna) {

		Boolean isSimian = Boolean.FALSE;

		char[][] table = convertToTable(dna);
		Boolean isSimiosRow = isSimiosRow(dna);
		Boolean isSimiosColumn = isSimiusColumn(table);

		Boolean isSimiusByDiagonallyR = isSimiusDiagonally(table, DnaConstants.DIRECTION_RIGHT);

		Boolean isSimiusByDiagonallyL = isSimiusDiagonally(table, DnaConstants.DIRECTION_LEFT);


		System.out.println(">>>> return Simios >\n isSimiosRow[" + isSimiosRow + "] " + "\nisSimiosColumn[" + isSimiosColumn
				+ "], " + "\n isSimiusByDiagonallyR[" + isSimiusByDiagonallyR + "], " + "\nby isSimiusByDiagonallyL["
				+ isSimiusByDiagonallyL + "], ");
		if (isSimiusByDiagonallyR || isSimiusByDiagonallyL || isSimiosRow || isSimiosColumn)
			isSimian = Boolean.TRUE;

		return isSimian;
	}

	private static Boolean isSimiosRow(String[] dna) {

		Boolean isSimios = Boolean.FALSE;
		for (int i = 0; i < dna.length; i++) {

			char item[] = dna[i].toCharArray();

			int count = 1;
			int countSimios = DnaConstants.COUNT_FOR_SIMIOS;
			for (int j = 0; j < item.length - 1; j++) {
				char atual = item[j];
				char compare = item[j + 1];
				if (atual == compare) {
					count++;
					if (count == countSimios) {
						isSimios = Boolean.TRUE;
					}
				} else if (count > 1)
					count = 1;

			}
		}
		return isSimios;

	}

	private static Boolean isSimiusColumn(char[][] tableDna) {
		
		Boolean isSimios = Boolean.FALSE;
		for (int col = 0; col < 6; col++) {

			int count = 1;
			int countSimios = DnaConstants.COUNT_FOR_SIMIOS;
			for (int row = 0; row < 5; row++) {

				char atual = tableDna[row][col];
				char compare = tableDna[row + 1][col];
				if (atual == compare) {
					count++;
					if (count >= countSimios) {
						isSimios = Boolean.TRUE;
						count = 1;
					}

				} else if (count > 1)
					count = 1;

			}

		}

		return isSimios;
	}

	private static Boolean isSimiusDiagonally(char[][] tableDna, String direction) {

		Boolean isSimios = Boolean.FALSE;

		int readAtColumn = 5;
		int readAtRow = 2;
		int startAtColumn = 0;
		int countSimios = DnaConstants.COUNT_FOR_SIMIOS;

		if (direction.equals(DnaConstants.DIRECTION_LEFT))
			startAtColumn = 3;

		if (direction.equals(DnaConstants.DIRECTION_RIGHT)) {
			startAtColumn = 0;
			readAtColumn = 2;
		}

		for (int col = startAtColumn; col <= readAtColumn; col++) {
			int count = 1;
			int rowCompare = 0;
			int columnCompare = 0;
			for (int row = 0; row <= readAtRow; row++) {
				char atual = tableDna[row][col];
				char compare = 0;
				rowCompare = row + 1;
				columnCompare = (direction.equals(DnaConstants.DIRECTION_RIGHT)) ? col + 1 : col - 1;
				compare = tableDna[rowCompare][columnCompare];
				if (atual == compare) {
					count++;
					rowCompare = rowCompare + 1;
					columnCompare = (direction.equals(DnaConstants.DIRECTION_RIGHT)) ? columnCompare + 1
							: columnCompare - 1;
					compare = tableDna[rowCompare][columnCompare];
					if (atual == compare) {
						count++;
						rowCompare = rowCompare + 1;
						columnCompare = (direction.equals(DnaConstants.DIRECTION_RIGHT)) ? columnCompare + 1
								: columnCompare - 1;
						compare = tableDna[rowCompare][columnCompare];
						if (atual == compare) {
							count++;
							if (count >= countSimios) {
								System.out.println(
										">>> Simios! by Diagonally > Row:[" + row + "], Col[" + col + "]<<<\n");
								isSimios = Boolean.TRUE;
								count = 1;
							}
						}
					} else if (count > 1)
						count = 1;
				} else if (count > 1)
					count = 1;
			}
		}
		return isSimios;
	}

	private static char[][] convertToTable(String[] dna) {
		char[][] table = new char[6][6];
		for (int i = 0; i < dna.length; i++) {
			char item[] = dna[i].toCharArray();

			System.out.println("table, item: " + Arrays.toString(item));
			table[i][0] = item[0];
			table[i][1] = item[1];
			table[i][2] = item[2];
			table[i][3] = item[3];
			table[i][4] = item[4];
			table[i][5] = item[5];
		}
		return table;
	}

}
