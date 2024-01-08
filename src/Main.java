import java.util.Scanner;

public class Main {

	public static void runnable(HashTable hashtable) {

		hashtable.setGrid('-', 60);
		System.out.println("\tWelcome to Java Hash-Table");
		hashtable.setGrid('-', 60);
		System.out.println("\tOperations");
		hashtable.setGrid('-', 60);

		System.out.println("\t[1] Put (Put a value in the table)");
		System.out.println("\t[2] View (View the table)");
		System.out.println("\t[3] Terminate (Close the program)");

		hashtable.setGrid('-', 60);

		System.out.println("Response: ");

	}
	/*
	 * Simple menu driven program
	 * has a do while to repeat iteration of process
	 * has a checker to and prompt 10 times only as the instruction provided
	 * validation of range from 1-30
	 */

	public static void main(String[] args) {
		HashTable hashtable = new HashTable();
		Scanner sc = new Scanner(System.in);

		do {
			runnable(hashtable);

			while (!sc.hasNextInt()) {
				System.out.println("Wrong data type input!!!\nCorrect inputs: 1, 34, 5");
				sc.next();
			}

			int userChoice = sc.nextInt();

			switch (userChoice) {
			case 1:
				hashtable.setGrid('-', 60);
				
				int userInputtedNum;
				System.out.println("Enter numbers ranging 1 - 30 only\nAccepting 10 numbers only:  ");

				for (int idxForPrompting = 0; idxForPrompting < 10; idxForPrompting++) {
					
					while (true) {
						userInputtedNum = sc.nextInt();
						if (userInputtedNum >= 1 && userInputtedNum <= 30) {
							break;
						} else {
							System.out.println("Accepting values from 1- 30 only ");
						}
						
					}
					System.out.println("That's " + (idxForPrompting + 1) + ", Keep typing number!!!");
					hashtable.put(userInputtedNum);
				}

				break;

			case 2:
				
				hashtable.ViewingTheTable(0);

				break;

			case 3:
				System.out.println("Terminate.....");
				System.exit(0);

				break;

			default:
				System.out.println("Wrong Input");
			}

		} while (true);

	}
}
