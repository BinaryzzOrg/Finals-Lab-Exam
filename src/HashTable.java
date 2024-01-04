
public class HashTable {
	// field variables
	private int[] hashtable;

	public int[] getHashtable() {
		return hashtable;
	}

	public HashTable() {
		this.hashtable = new int[20];
	}

	private int performHashKeyFunction(int value) {
		return value % 20;
	}
	
	private void performLinearProbing(int hashkey, int value) {
		while (getHashtable()[hashkey] != 0 || getHashtable()[hashkey] == value) {

			hashkey = (hashkey + 1) % 20;
		}

		getHashtable()[hashkey] = value;

	}

	public void put(int value) {

		int hashkey = performHashKeyFunction(value);
		performLinearProbing(hashkey, value);

	}

	public String setGrid(char symbol, int numTimes) {
		String grid = "";
		for (int idxForDesigning = 0; idxForDesigning < numTimes; idxForDesigning++) {
			grid += symbol;
		}

		grid += "\n";

		return grid;

	}

	public String toString() {
		String concat = "Hash Table\n";
		concat += setGrid('_', 20);

		for (int hashkey = 0; hashkey < 20; hashkey++) {
			concat += hashkey + "     |       ";

			if (getHashtable()[hashkey] != 0) {
				concat += hashtable[hashkey] + "\n" + setGrid('_', 20);
				System.out.println();
			} else {
				concat += "\t\n" + setGrid('_', 20);
			}

			System.out.println();

		}

		return concat;

	}
}// end main
