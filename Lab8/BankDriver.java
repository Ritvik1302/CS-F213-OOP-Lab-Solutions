public class BankDriver {
	public static void main(String[] args) {
		Bank b1 = new Bank();

		b1.addAccount(new Account(2545, 50000.00, "Ritvik"));
		b1.addAccount(new Account(2354, 18.00, "Prerit"));

		System.out.println(b1.deposit(2545, 5000));
		System.out.println(b1.withdraw(2545, 4000));
		System.out.println(b1.removeAccount(2354));
		System.out.println(b1.getAccount(2545));
	}
}
