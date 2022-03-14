import java.io.*;
import java.util.LinkedList;

public class EligibilityProgram {

	private void printPersentageBar(int j) {
		System.out.print("[");
		for (int i = 0; i < 100; i++) {
			if (j != 0) {
				System.out.print("\\");
				j--;
			} else
				System.out.print("_");
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		// CSV = Comma-Separated Values
		// text file that uses a comma to separate values

		String file = "src\\Farmers2.csv";
		BufferedReader reader = null;
		String line = "";
		LinkedList<Farmer> farmers = new LinkedList<Farmer>();
		double nOfFailure = 0;
		double nOfSuccess = 0;
		EligibilityProgram ep = new EligibilityProgram();

		try {
			reader = new BufferedReader(new FileReader(file));
			// ›«∆œ… j Â‰« «‰Â „«ÌÕ›Ÿ «·”ÿ— «·«Ê· «··Ì ÂÊ ⁄»«—… ⁄‰ «”„«¡ «·« —Ì»ÊÌ 
			int j = 1;
			while ((line = reader.readLine()) != null) {
				if (j == 1) {
					j++;
				} else {
					String[] row = line.split(",");
					farmers.add(new Farmer((int) Integer.parseInt(row[0].trim()), (String) row[1],
							(double) Double.parseDouble(row[2].trim()), (int) Integer.parseInt(row[3].trim()),
							(String) row[4], (int) Integer.parseInt(row[5].trim()), row[6].equalsIgnoreCase("yes"),
							row[7].equalsIgnoreCase("yes"), (double) Double.parseDouble(row[8].trim()),
							(int) Integer.parseInt(row[9].trim())));
//					 f1 = new Farmer((int)Integer.parseInt(row[0].trim()), (String)row[1], (double)Double.parseDouble(row[2].trim()), (int)Integer.parseInt(row[3].trim()), (String)row[4], (int)Integer.parseInt(row[5].trim()), row[6].equalsIgnoreCase("yes"), row[7].equalsIgnoreCase("yes"), (double)Double.parseDouble(row[8].trim()), (int)Integer.parseInt(row[9].trim()) );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ID             Name             Eligible");
			System.out.println("----------------------------------------\n");
			while (farmers.isEmpty() != true) {
				Farmer temp = farmers.pop();
				temp.print();
				if (temp.isEligible())
					nOfSuccess++;
				else
					nOfFailure++;
			}
			System.out.println(
					"----------------------------------------\nTotal records: " + (int) (nOfFailure + nOfSuccess));
			System.out.println("Number of Eligible: " + (int) nOfSuccess);
			ep.printPersentageBar((int) Math.rint((nOfSuccess / (nOfFailure + nOfSuccess)) * 100.00));
			System.out.println(" " + String.format("%.2f", (nOfSuccess / (nOfFailure + nOfSuccess)) * 100.00) + "%\n");
			System.out.println("Number of Non-Eligible: " + (int) nOfFailure);
			ep.printPersentageBar((int) Math.rint((nOfFailure / (nOfFailure + nOfSuccess)) * 100.00));
			System.out.println(" " + String.format("%.2f", (nOfFailure / (nOfFailure + nOfSuccess)) * 100.00) + "%");
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
