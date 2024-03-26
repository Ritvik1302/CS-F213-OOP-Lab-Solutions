import java.util.Scanner;
import java.io.*;

public class BankFileTester {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Filename");
			String file = in.nextLine();
			System.out.println(file);
			Bank b = new Bank(7);
			BankIO.readFile(file, b);
			String file2 = in.nextLine();
			BankIO.write(file2, b);
			System.out.println(b);
			BankIO.readAccount(in);
		} catch (IOException exception) {
			System.out.println("\n*****ERROR*****: " + exception.getMessage()
					+ "\n");
		}
	}
}
