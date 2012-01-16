package demo.arrays;

public class DemoMultiDimArrays {

	public static void main(String[] args) {
		demoRectangularArrays();
		demoJaggedArrays();
	}

	public static void demoRectangularArrays() {

		int[][] timesTable = new int[13][13];

		for (int r = 1; r < timesTable.length; r++) {
			for (int c = 1; c < timesTable[r].length; c++) {
				timesTable[r][c] = r * c;
			}
		}
		
		System.out.println("\nRectangular array...");
		for (int r = 1; r < timesTable.length; r++) {
			for (int c = 1; c < timesTable[r].length; c++) {
				System.out.print(timesTable[r][c] + "\t");
			}
			System.out.println();
		}
	}


	public static void demoJaggedArrays() {

		int[][] examMarks = new int[3][];
		
		examMarks[0] = new int[5];
		examMarks[1] = new int[8];
		examMarks[2] = new int[10];

		for (int r = 0; r < examMarks.length; r++) {
			for (int c = 0; c < examMarks[r].length; c++) {
				examMarks[r][c] = (int)(100 * Math.random());
			}
		}
		
		System.out.println("\nJagged array...");
		for (int r = 0; r < examMarks.length; r++) {
			for (int c = 0; c < examMarks[r].length; c++) {
				System.out.print(examMarks[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
