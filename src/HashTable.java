
public class HashTable {
	/*
	 * int[] hashtable = the array table with a size of 17 int DEFAULTSIZE = the
	 * size of the table also the n for the formula of hashsum which is k % n int
	 * nTotalItemsinTable = current total items inside the table
	 */
	private int[] hashtable;
	private static final int DEFAULTSIZE = 17;
	private static int nTotalItemsinTable = 0;

	public int[] getHashtable() {
		return hashtable;
	}

	public HashTable() {
		this.hashtable = new int[DEFAULTSIZE];
		fillFirstWithNeg(hashtable, -1);
	}

	/*
	 * Purpose is for printing the values and determining the collisions If not (!=)
	 * -1 then means it has already taken so thus a collision It set first the empty
	 * getHashtable with -1
	 */

	public void fillFirstWithNeg(int[] ArrayToBeFill, int fillWith) {
		for (int idxOfElem = 0; idxOfElem < ArrayToBeFill.length; idxOfElem++) {
			ArrayToBeFill[idxOfElem] = fillWith;
		}

	}

	/*
	 * Since the formula given in the instructions is n % 17 this method returns the
	 * value modulo DEFAULTSIZE or 17 returns it in int value
	 */

	private int ComputeHashSum(int value) {
		return value % DEFAULTSIZE;
	}

	/*
	 * Performs linear probing we use ++hashkey or the pre-incremented hashkey since
	 * for printing the next candidate slot also the getHashtable()[hashkey] = value
	 * is used so that if it reach the end it will go back to index 0 to repeat the
	 * searching for empty slot for instance we are in the last spot and it's pre
	 * incremented and we know that an array is 0-16 (when n-size 17) so we
	 * preincremented it to go to 17 to perform the 17 % 17 = 0 thus the cycle
	 * continues After that if that spot is empty which is determined by the doing
	 * the fillFirstWithNeg method (turns the empty array into -1 upon invoking
	 * constructor) it's gonna put the value to that empty spot and increment its
	 * nItems to update the item status
	 */

	private void performLinearProbing(int hashkey, int value) {
		while (getHashtable()[hashkey] != -1) {
			++hashkey;
			System.out.println("Collision Spotted, performing Linear Probing...\nLet's try with " + hashkey);
			hashkey %= DEFAULTSIZE;
		}

		getHashtable()[hashkey] = value;
		nTotalItemsinTable++;

	}

	/*
	 * basically the methods inside here are explain on previous comments
	 * ComputeHashSum returns the hashsum stores it in hashkey performLinearProbing
	 * checks if there's collision and also process putting the values to the table
	 * array
	 */

	public void put(int value) {

		int hashkey = ComputeHashSum(value);
		performLinearProbing(hashkey, value);

	}

	public void setGrid(char symbol, int numTimes) {
		for (int idxForDesigning = 0; idxForDesigning < numTimes; idxForDesigning++) {
			System.out.print(symbol);
		}

		System.out.println();
	}

	/*
	 * We use the initResize so that the values will only iterates for 10 times
	 * after that it will create now a another visual look of table we do this since
	 * its gonna be long in the console if it printed one value per 17 times (as the
	 * size) vertically or horizontally setGrid is just gonna print a char symbol
	 * for further designing in the first line on the method we use 2 since 17 % 10
	 * also 17 is greater so it needs another table Basically it means that it will
	 * create a two tables from 0-9 to 10-16 we check if the value and index is < 10
	 * to format the single digit or double digit it checks also if its less than to
	 * defaultsize since printing by 17 will cause out of bounds it means this line
	 * of code will check if the value is only less than to default size so that we
	 * only print the values inside of that size if not it just gonna print
	 * whitespaces or | to beautify formatting Lastly it will print the totalitems
	 * and size
	 */

	public void ViewingTheTable(int initResize) {
		setGrid('-', 51);

		System.out.println("\nHash Table with size " + DEFAULTSIZE);

		for (int i = 0; i < 2; i++) {

			initResize += 10;

			setGrid('-', 51);

			for (int idxForPrintingtheVal = initResize
					- 10; idxForPrintingtheVal < initResize; idxForPrintingtheVal++) {
				if (idxForPrintingtheVal < DEFAULTSIZE) {
					if (getHashtable()[idxForPrintingtheVal] == -1) {
						System.out.print("|    ");
					} else {
						if (getHashtable()[idxForPrintingtheVal] < 10) {
							System.out.print("| " + getHashtable()[idxForPrintingtheVal] + "  ");
						} else {
							System.out.print("| " + getHashtable()[idxForPrintingtheVal] + " ");

						}
					}
				} else {
					System.out.print("|    ");
				}
			}

			System.out.println("|");
			setGrid('-', 51);

			for (int idxForTheindexPrint = initResize - 10; idxForTheindexPrint < initResize; idxForTheindexPrint++) {
				if (idxForTheindexPrint < DEFAULTSIZE) {
					if (idxForTheindexPrint < 10) {

						System.out.print("| " + idxForTheindexPrint + "  ");
					} else {
						System.out.print("| " + idxForTheindexPrint + " ");
					}

				} else {
					System.out.print("|    ");
				}
			}

			System.out.println("|");
			setGrid('-', 51);

		}

		System.out.println("Total items: " + nTotalItemsinTable);
		System.out.println("Slots as of now: " + (DEFAULTSIZE - nTotalItemsinTable));

	}
}// end main
