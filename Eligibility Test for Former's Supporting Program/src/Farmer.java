
public class Farmer {

	private int id;
	private String name;
	private double salary;
	private int age;
	private String status;
	private int nChildren;
	private boolean citizenAccount;
	private boolean otherIncome;
	private double balance;
	private int nSheeps;
	private boolean eligibility;

	public Farmer(int id, String name, double salary, int age, String status, int nChildren, boolean citizenAccount,
			boolean otherIncome, double balance, int nSheeps) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.status = status;
		this.nChildren = nChildren;
		this.citizenAccount = citizenAccount;
		this.otherIncome = otherIncome;
		this.balance = balance;
		this.nSheeps = nSheeps;
		this.eligibility = eligibilityTest();
	}

	

	private boolean eligibilityTest() {
		if (salary > 10000) {
			return false;
		} else if (age < 20 || age > 70) {
			return false;
		} else if (status.equalsIgnoreCase("married") == false) {
			return false;
		} else if (nChildren <= 2) {
			return false;
		} else if (citizenAccount == false) {
			return false;
		} else if (otherIncome == true) {
			return false;
		} else if (balance > 100000.00) {
			return false;
		} else if (nSheeps > 50000) {
			return false;
		} else
			return true;
	}

	public void print() {
		String e;
		if (this.eligibility)
			e = "Yes";
		else
			e = "No";
		System.out.println(this.id + "       " + this.name + "\t        " + e);
	}

	public boolean isEligible() {
		return eligibility;
	}

}
