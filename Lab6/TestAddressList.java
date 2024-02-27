import java.util.StringTokenizer;

class Address{
	private String line1;
	private String line2;
	private String line3;
	private char[] city;
	private char[] state;
	private String pin;
	public String getLine1() {
		return line1;
	}
	public String getLine2() {
		return line2;
	}
	public String getLine3() {
		return line3;
	}
	public String getCity() {
		return city.toString();
	}
	public String getState() {
		return state.toString();
	}
	public String getPin() {
		return pin;
	}
	
	public Address(String address) {
		StringTokenizer st = new StringTokenizer(address, "$");
		line1 = st.nextToken();
		line2 = st.nextToken();
		line3 = st.nextToken();
		city = st.nextToken().toCharArray();
		state = st.nextToken().toCharArray();
		pin = st.nextToken();
	}
	
}
class AddressList {
	public static int countAddressWithCity(Address[] addressList, String city) {
		/*
		 * This method returns the count of the addresses from addressList which
		 * have the city attribute equals to city parameter passed for this
		 * method. If the length of any passed argument is zero or value of any
		 * passed argument is null then it returns -1.
		 */
		int count = 0;
		for(int i=0;i<addressList.length;i++){
			if(addressList[i].getCity().compareTo(city)==0)count++;
		}
		return count;
	}// End of method countAddressWithCity()

	public static int countAddressWithPin(Address[] addressList, String strP) {
		/*
		 * This method returns the count of the addresses from addressList which
		 * have the pin attribute starting with strP parameter passed for this
		 * method. If the length of any passed argument is zero or value of any
		 * passed argument is null then it returns -1.
		 */
		int count = 0;
		for(int i=0;i<addressList.length;i++){
			if(addressList[i].getPin().compareTo(strP)==0)count++;
		}
		return count;
	}// End of method countAddressWithCity()

	public static Address[] getAddressWithCity(Address[] addressList, String city) {
		/*
		 * This method returns all the addresses from addressList by storing
		 * them in String[] which have the city attribute equals to city
		 * parameter passed for this method. If the length of any passed
		 * argument is zeroor value of any passed argument is null then it
		 * returns null. If addressList does not contain any address with city
		 * attribute value equal to city parameter passed for this method even
		 * then it returns null.
		 */
		int count = countAddressWithCity(addressList,city);
		Address[] list = new Address[count];
		int no=0;
		for(int i=0;i<addressList.length;i++){
			if(addressList[i].getCity().compareTo(city)==0){
				list[no] = addressList[i];
			}
		}
		return list;
	}// End of method getAddressWithCity()

	public static Address[] getAddressWithPin(Address[] addressList, String strP) {
		/*
		 * This method returns all the addresses from addressList by storing
		 * them in String[] which have their pin attribute starting with strP
		 * parameter passed for this method. If the length of any passed
		 * argument is zero or value of any passed argument is null then it
		 * returns null. If addressList does not contain any address whose pins
		 * attribute value starts with strP parameter passed for this method
		 * even then it returns null.
		 */
		int count = countAddressWithPin(addressList,strP);
		Address[] list = new Address[count];
		int no=0;
		for(int i=0;i<addressList.length;i++){
			if(addressList[i].getPin().compareTo(strP)==0){
				list[no] = addressList[i];
			}
		}
		return list;
	}// End of method getAddressWithCity()
}// End of class AddressList

public class TestAddressList {
	public static void main(String[] args){
		Address[] list = new Address[2];
		list[0] = new Address("123$hn1$rd2${'k','p','t'}${'p','b'}$123");
		list[1] = new Address("123$hn1$rd2${'k','p','t'}${'p','b'}$123");
		System.out.println(AddressList.countAddressWithPin(list,"123"));
	}
}