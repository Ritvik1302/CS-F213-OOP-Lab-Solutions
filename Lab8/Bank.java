import java.util.*;

public class Bank {
	private ArrayList<Account> accts;
	int maxActive;
	public Bank(){
		accts = new ArrayList<Account>();
	}
	public boolean addAccount(Account newone) {
		return accts.add(newone);
	}
	public Account getAccount(long acctnum){
		ListIterator itr = accts.listIterator();
		while (itr.hasNext()) {
			Account element = (Account) itr.next();
			if (element.getAcctNumber() == (acctnum)) {
				return element;
			}
		}
		return null;
	}
	public boolean removeAccount(long acctnum) {
		ListIterator itr = accts.listIterator();
		while (itr.hasNext()) {
			Account element = (Account) itr.next();
			if (element.getAcctNumber() == (acctnum)) {
				accts.remove(element);
				return true;
			}
		}
		return false;
	}

	public double deposit(long acctnum, double amount) {
		ListIterator itr = accts.listIterator();
		while (itr.hasNext()) {
			Account element = (Account) itr.next();
			if (element.getAcctNumber() == (acctnum)) {
				element.setBalance(element.getBalance() + amount);
				return 1;
			}
		}
		return -1;
	}

	public double withdraw(long acctnum, double amount) {
		ListIterator itr = accts.listIterator();
		while (itr.hasNext()) {
			Account element = (Account) itr.next();
			if (element.getAcctNumber() == (acctnum)) {
				if(element.getBalance()<amount)return -1;
				element.setBalance(element.getBalance() - amount);
				return 1;
			}
		}
		return -1;
	}
	@Override
	public String toString(){
		String str = "";
		ListIterator itr = accts.listIterator();
		while (itr.hasNext()) {
			str += itr.next().toString();
		}
		return str;
	}
}