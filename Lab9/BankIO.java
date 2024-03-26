import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class BankIO {
	public static void readFile(String filename, Bank bank) {
		Scanner in;
		try {
			in = new Scanner(new File(filename));
			while (in.hasNextLine()) {
				String s = in.nextLine();
				String[] tokens = s.split(" ");
				System.out.println(tokens[0]);
				System.out.println(tokens[1]);
				int account = Integer.parseInt(tokens[0]);
				double amount = Double.parseDouble(tokens[1]);
				bank.add(new BankAccount(amount, account));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}

	public static BankAccount readAccount(Scanner in) throws IOException {
		int account = in.nextInt();
		double amount = in.nextDouble();
		if (amount < 0) {
			throw new IOException(
					"Accounts with a negative balance cannot be created!");
		}
		// TODO TASK 2: add code here to throw an exception if the account
		// number isn't 5 digits.
		if (account > 99999 || account < 10000) {
			throw new IOException(
					"Accounts with less than 5 digit account numbers cannot be created!");
		}

		return new BankAccount(amount, account);
	}

	public static void write(String filename, Bank bank) throws FileNotFoundException{
		try {
			PrintWriter out = new PrintWriter(filename);
			out.println(bank.toString());
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
}
