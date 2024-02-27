import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

class Name {
	private String fname; // First Name
	private String mname; // Middle Name
	private String lname; // Last Name

	// provide accessor methods as per the given specification
	// provide implementation for getName() method as per the given
	// specification

	Name(String name) {
		/*
		 * Complete the constructor by extracting the values of three name
		 * fields. Note that name value may be either comma separated or
		 * semicolon separated
		 */
		StringTokenizer st = new StringTokenizer(name, ",");
		if (st.countTokens() == 3) {
			fname = st.nextToken();
			mname = st.nextToken();
			lname = st.nextToken();
		} else {
			st = new StringTokenizer(name, ";");
			fname = st.nextToken();
			mname = st.nextToken();
			lname = st.nextToken();
		}
	}

	public String getFname() {
		return fname;
	}

	public String getMname() {
		return mname;
	}

	public String getLname() {
		return lname;
	}

	public String getName() {
		return fname + " " + mname + " " + lname;
	}
} // End of class Name.

class Student {
	private Name name; // name of student
	private int age;// age of student

	/*
	 * Complete the Student class by adding proper constructor, accessor methods
	 * and by adding any other method which are required as per specification
	 */
	// Write Your Code From Here
	public Student(Name name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Name getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name.getName() + ", age=" + age + "]";
	}
}// End of Student class

class StudentList {

	public static Student[] list = new Student[10]; // list of students
	public static int count = 0; // count of students added in the list

	public static void addStudent(Student std) {
		if (count >= 20)
			return; // if count is already 20 or more then return
		list[count] = std;
		count++;
	}

	public static Student[] getStudentsWithAge(int age) {
		/*
		 * This method returns all the students whose age is equal to age
		 * parameter of this method. If no such student is found then it returns
		 * null.
		 */
		// Write Your Code From Here
		int no = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getAge() == age) {
				no++;
			}
		}
		Student[] students = new Student[no];
		no=0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getAge() == age) {
				students[no] = new Student(list[i].getName(), list[i].getAge());
				no++;
			}
		}
		return students;
	}

	public static Student[] getStudentsWithLastName(String lastName) {
		/*
		 * This method returns all the students whose last name attribute value
		 * matches with lastName parameter of this method. If no such students
		 * is found then it returns null.
		 */
		int no = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().getLname().compareTo( lastName)==0) {
				no++;
			}
		}
		Student[] students = new Student[no];
		no=0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().getLname().compareTo( lastName)==0) {
				students[no] = new Student(list[i].getName(), list[i].getAge());
				no++;
			}
		}
		return students;
		// Write Your Code From Here
	}

	public static Student[] getStudentsInRange(int minAge, int maxAge) {
		/*
		 * This method returns all the students whose age falls between minAge
		 * and maxAge (both parameters inclusive)
		 */
		// Write Your Code From Here
		int no = 0;
		
		for (int i = 0; i < list.length; i++) {
			if (list[i].getAge() <= minAge && list[i].getAge() >= maxAge) {
				no++;
			}
		}
		Student[] students = new Student[no];
		no=0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getAge() >= minAge && list[i].getAge() <= maxAge) {
				students[no] = new Student(list[i].getName(), list[i].getAge());
				no++;
			}
		}

		return students;
	}
}// End of class StudentList

class Test {
	static Scanner in = new Scanner(System.in);
	public static Student readStudent() throws IOException {
		/*
		 * This method reads the student details and returns the Student
		 * instance. Values to be read from System.in are: 1. First name of
		 * Student, 2. Middle name of student, 3. Last name of Student, 4. Name
		 * format (1 for comma(,) separated and 2 for semicolon separated), 5.
		 * age of student
		 */
		System.out.println("Enter Name: ");
		String name = in.next();
		Name newname = new Name(name);
		System.out.println("Enter Age: ");
		int age = in.nextInt();
		Student s = new Student(newname, age);
		return s;
	} // End of readStudent() Method

	public static void main(String args[]) throws IOException {
		/*
		 * 1. Write java code for reading details of 10 students and add them in
		 * the static list ofStudentListclass.
		 */
		// StudentList list = new StudentList();
		for (int i = 0; i < 10; i++) {
			StudentList.addStudent(readStudent());
		}
		/*
		 * 2. Write java code for displaying the all the students with age 20
		 * from static list field of StudentList class
		 */
		Student[] age20 = StudentList.getStudentsWithAge(20);
		for (int i = 0; i < age20.length; i++) {
			System.out.println(age20[i]);
		}
		/*
		 * 3. Write java code for displaying the student details for all
		 * students having last name �Sharma� from static list of StudentList
		 * class
		 */
		Student[] nameSharma = StudentList.getStudentsWithLastName("Sharma");
		for (int i = 0; i < nameSharma.length; i++) {
			System.out.println(nameSharma[i]);
		}
		/*
		 * 4. Write java code for displaying all the students whose age falls in
		 * the range minAge = 16 and maxAge = 20 from static list of StudentList
		 * class
		 */
		Student[] range16to20 = StudentList.getStudentsInRange(16, 20);
		for (int i = 0; i < range16to20.length; i++) {
			System.out.println(range16to20[i]);
		}
	}// End of main() Method
}// End of Test class