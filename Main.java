import java.util.Scanner;

class StudentManagementSystem {

	String[][] data = new String[100][5];
	Scanner scanner;
	int i;
	int rollNumber;
	
	StudentManagementSystem(){
		
		i = 0;
		rollNumber = 10000;
		scanner = new Scanner(System.in);

		menu();

	}
 
	public void menu(){
	
		System.out.println("\n ********************** WELCOME TO STUDENT MANAGEMENT SYSTEM ******************** \n");
		System.out.println(" 1. Add Student \n 2. Remove Student \n 3. Update Student \n 4. Get Student By Roll Number \n 5. Get All Student \n 6. Exit ");
			
		System.out.print("\n Enter ::  ");
		int choice = Integer.parseInt(scanner.nextLine());

		switch(choice){

			case 1:
				addStudent();
				break;

			case 2:
				removeStudent();
				break;

			case 3:
				updateStudent();
				break;

			case 4:
				getStudent();
				break;
				
			case 5:
				getAllStudents();
				break;

			case 6:
				System.out.println("Successfully Exited the Program");
				scanner.close();
				System.exit(0);
			}

			
	
	}	

	public void addStudent(){

		System.out.println("\n\n------------------------------Enter Your Information-----------------------------\n\n");

		System.out.print(" Enter Your Name : ");
		String name = scanner.nextLine();

		System.out.print("\n Enter Your Father Name : ");
		String fatherName = scanner.nextLine();

		System.out.print("\n Enter Your Age : ");
		String age = scanner.nextLine();

		System.out.print("\n Enter Your School Name : ");
		String schoolName = scanner.nextLine();

		
		String rollNum = Integer.toString(rollNumber);
		
		rollNumber++;
		
		data[i][0] = rollNum;
		data[i][1] = name;
		data[i][2] = fatherName;
		data[i][3] = age;
		data[i][4] = schoolName;

		i++;
		
		System.out.println("\n\n " + name + "Successfully Added . Your Roll Number is " + rollNum + "\n\n");

		menu();

	}

	public void removeStudent(){

		System.out.print("Enter Student Roll Number : ");
		int num = Integer.parseInt(scanner.nextLine());
		int j = checkStudentId(num);

		if ( j != -1 ){
			
			data[j][0] = "000000";
			System.out.println("Successfully Deleted");

		} else {

			System.out.println(" Student not Found ");

		}
		

		menu();

	}

	public void getStudent(){

		System.out.print("Enter Student Roll Number : ");
		int num = Integer.parseInt(scanner.nextLine());
		int j = checkStudentId(num);
		
		if ( j != -1 ){

			System.out.println("\n---------------------------------------------------------------------------------\n");
		
			System.out.println(" Roll Number : " + data[j][0] + "\n Name : " + data[j][1] + "\n Father Name : " + data[j][2] + "\n Age : " + data[j][3] + "\n School :  "  + data[j][4] );

			System.out.println("\n---------------------------------------------------------------------------------\n");

		} else {

			System.out.println("Student Not Found ");

		}

		menu();

	}

	public void updateStudent(){

		System.out.print("Enter Student Roll Number : ");
		int num = Integer.parseInt(scanner.nextLine());
		int j = checkStudentId(num);
		
		if ( j != -1) {
		
			System.out.print("What You Want To Update ?? \n 1. Name \n 2. Father Name \n 3. Age \n 4. School Name \n Enter :: ");
			int updateChoice = Integer.parseInt(scanner.nextLine());

			if ( updateChoice == 1) {

				System.out.print("Enter Your New Name : ");
				String newName = scanner.nextLine();
				data[j][1] = newName;
				System.out.println("Successfulyy Updated ");
				
			} else if ( updateChoice == 2 ){

				System.out.print("Enter Your New Father Name : ");
				String newFatherName = scanner.nextLine();
				data[j][2] = newFatherName;
				System.out.println("Successfulyy Updated ");

			} else if ( updateChoice == 3 ){
				
				System.out.print("Enter Your New Age : ");
				String newAge = scanner.nextLine();
				data[j][3] = newAge;
				System.out.println("Successfulyy Updated ");

			} else if ( updateChoice == 4 ){

				System.out.print("Enter Your New School Name : ");
				String newSchoolName = scanner.nextLine();	
				data[j][4] = newSchoolName;
				System.out.println("Successfulyy Updated ");
				
			}

		} else {

			System.out.println(" Student Not Found ");

		}

		menu();

	}

	public void getAllStudents(){

		System.out.println("\n\n ********************** ALL STUDENTS DETAILS ********************  \n\n");

		for(int j=0;j<i;j++){

			if (data[j][0] == "000000"){continue;}

			System.out.println("\n---------------------------------------------------------------------------------\n");
		
			System.out.println(" Roll Number : " + data[j][0] + "\n Name : " + data[j][1] + "\n Father Name : " + data[j][2] + "\n Age : " + data[j][3] + "\n School :  "  + data[j][4] );

			System.out.println("\n---------------------------------------------------------------------------------\n");

		}

		menu();

	}

	public int checkStudentId(int id){
		
		for (int j=0;j<i;j++){

			int rollNum = Integer.parseInt(data[j][0]);
		
			if ( rollNum == id ){
			
				return j;

			}

		}

		

		return -1;

	}

}

public class Main {

	public static void main(String[] args){

		StudentManagementSystem SMS = new StudentManagementSystem();

	}

}

