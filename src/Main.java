import java.util.Scanner;

public class Main {

	public static void runnable(HashTable hashtable) {

		System.out.println(hashtable.setGrid('-', 60));
		System.out.println("\tWelcome to Java Hash-Table");
		System.out.println(hashtable.setGrid('-', 60));
		System.out.println("\tOperations");
		System.out.println(hashtable.setGrid('-', 60));

		System.out.println("\t[1] Put (Put a value in the table)");
		System.out.println("\t[2] View (View the table)");
		System.out.println("\t[3] Terminate (Close the program)");

		System.out.println(hashtable.setGrid('-', 60));

		System.out.println("Response: ");

	}

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
				System.out.println(hashtable.setGrid('-', 60));

				System.out.println("Enter numbers ranging 1 - 30 only\nAccepting 10 numbers only:  ");

				for (int idxForPrompting = 0; idxForPrompting < 10; idxForPrompting++) {
					int userInputtedNum;

					do {
						userInputtedNum = sc.nextInt();
					} while (userInputtedNum < 1 || userInputtedNum > 30);

					hashtable.put(userInputtedNum);
				}

				break;

			case 2:
				
				System.out.print(hashtable.toString());

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
