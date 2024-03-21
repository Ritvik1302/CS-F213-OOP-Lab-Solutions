public class Account {
	private long acctNumber;
	private double balance;
	private String name;

	public Account(long acctNumber, double balance, String name) {
		super();
		this.acctNumber = acctNumber;
		this.balance = balance;
		this.name = name;
	}

	public long getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(long acctNumber) {
		this.acctNumber = acctNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [acctNumber=" + acctNumber + ", balance=" + balance
				+ ", name=" + name + "]";
	}
}