import java.util.Scanner;

public class Main {
	// field variables
	private static HashTable hashTable = new HashTable();
	static boolean workOnlyOneTime = true;
	public static void main(String[] args) {
	
		Menu();
	}// end method

	/*
	 * The PrintMenuChoices method returns a formatted string for MainMenu. This
	 * formatted string is displayed to the user when they run the code for the
	 * first time. The method is also passed as a parameter to other methods that
	 * use the 'prompt' String.
	 */
	public static String PrintMenuChoices() {
		String MenuChoicesAsString =
		//@formatter:off
								"\n" + 
								"       {MainMenu}\n"+ 
								"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
								"┃ 【 1 】 Add	 \n" +
								"┃ 【 2 】 ViewHashTable \n" + 
								"┃ 【 3 】 Exit \n" + 
								"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
								"》 ";
				//@formatter:on
		return MenuChoicesAsString;
	}// end method

	/*
	 * The MenuChoices method contains the following operations: Add, ViewHashTable,
	 * and Exit. This method calls the PrintMenuChoices that prints out the choices
	 * for modifying the HashTable that is chosen by the user. MenuChoices method
	 * also handles miss inputs of the user and loops if it detects one.
	 */
	public static void Menu() {
		System.out.print(PrintMenuChoices());
		
		/*
		 * case 1 checks first if the first inputted number corresponds to its data type
		 * next it will check if the hashtable if it constains the same value 
		 */
		
		
		switch (CheckUserInput(PrintMenuChoices())) {
		
		case 1: {// AddA
			if (workOnlyOneTime) {
			int Counter = 10;
			
			int valueToCheckBeforePutting;
			for (int index = 0; index < Counter; index++) {
				while (true) {
					System.out.print("Enter a number : ");
					valueToCheckBeforePutting = CheckUserInput("Enter a number : ");

					if (hashTable.contains(valueToCheckBeforePutting)) {
						System.out.println("Number is not unique, already in the table");
					} else {
						break;
					}

				}

				hashTable.put(valueToCheckBeforePutting);

			} // end for
			
			
			
			workOnlyOneTime = false;

			hashTable.ViewingTheTable(0);
			} else {
				System.out.println("Not allowed to add now since adding to another 10 unique elements will result in overflow");
			}
			
			break;
		}

		case 2: {// ViewHashTable
			hashTable.ViewingTheTable(0);
			break;
		}

		case 3: {// Exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		}

		default:
			// @formatter:off
			System.out.println("\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Error: \n" +
					"┇ Input is not a valid Menu choice. \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Msg: \n" +
					"┇ \033[3mPlease enter only 1 to 3 as input\033[0m \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end method

		Menu();
	}// end method
	
	
	
	/*
	 * The CheckUserInput method scans the user's input and checks if it is an
	 * integer. If the input is an integer, it is stored in the 'value' variable and
	 * returns it. If the input is not an integer, an error message is displayed,
	 * and the user is prompted to enter an integer value. The 'prompt' parameter is
	 * used for different scenarios of printing needed for certain menus.
	 */
	public static int CheckUserInput(String prompt) {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int value = sc.nextInt();
			return value;
		} // end if

		// @formatter:off
			System.out.println("\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Error: \n" +
						"┇ Input is not an integer value. \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Msg: \n" +
						"┇ \033[3mPlease enter INTEGER input only\033[0m \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
		// @formatter:on
		System.out.print(prompt);
		return CheckUserInput(prompt);
	}// end if
}// end method