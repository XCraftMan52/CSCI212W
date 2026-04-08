package mypackage;

public class Search {
	
	String[][] data = {
		    /* key    name             age  e-mail           */
	        {"K0", "Abby Linc",        "18", "a1@ch.org"},    /* record 1*/
	        {"K1", "John Doe",         "23", "jd@abc.com"},   /* record 2 */
	        {"K2", "Janet Basco",      "39", "jb@ids.com"},   /* record 3 */
	        {"K3", "Charles River",    "64", "cr@neit.edu"},  /* record 4 */
	        {"K4", "Barack Obama",     "50", "bo@democrat.gov"}, /* record 5 */
	        {"K5", "Sarah Palin",      "44", "sp@republican.gov"}, /* record 6 */
	        {"K6", "John McCain",      "72", "jm@it.com"},    /* record 7 */
	        {"K7", "George Bush",      "54", "gb@white.com"}, /* record 8 */
	        {"K8", "Al Gore",          "56", "ag@vp.edu"},    /* record 9 */
	        {"K9", "Dick Cheney",      "60", "dc@vp.gov"}     /* record 10 */
	};
	
	public int divideMethod(String keyToSearch) {
		int len = keyToSearch.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			int decVal = keyToSearch.charAt(i);
			sum = sum + decVal;
		}
		sum = sum % 10;
		return sum;
	}
	
	String[][] datahashed = new String[200][4];
	
	
	public int hash(String keyToSearch) {
	    System.out.println("Searching for " + keyToSearch + " using hash division method.");

	    int foundAtIndex = divideMethod(keyToSearch);

	    if (datahashed[foundAtIndex][0] != null && datahashed[foundAtIndex][0].equals(keyToSearch)) {
	        System.out.println("Key " + keyToSearch + " is found at index " + foundAtIndex + " after 1 read.");
	        return foundAtIndex;
	    } else {
	        System.out.println("Key " + keyToSearch + " was NOT found in the hashtable.");
	        return -1;
	    }
	}
	
	
	public String displayRecordFromHashtable(int index) {
		return "Record = "
				+ datahashed[index][0]
				+ ", "
				+ datahashed[index][1]
				+ ", "
				+ datahashed[index][2]
				+ ", "
				+ datahashed[index][3];
	}
	
	public static void main(String[] args) {
		Search search = new Search();
		
		for (int i = 0; i < search.data.length; i++) {
			System.out.println(search.divideMethod("K" + (new Integer(i)).toString()));
		}
		
		for (int i=0; i<search.data.length; i++) {
			int generatedHashIndex = search.divideMethod(search.data[i][0]);
			search.datahashed[generatedHashIndex][0] = search.data[i][0];
			search.datahashed[generatedHashIndex][1] = search.data[i][1];
			search.datahashed[generatedHashIndex][2] = search.data[i][2];
			search.datahashed[generatedHashIndex][3] = search.data[i][3];

		}
		
		int rowItWasFound = search.hash("K9");
		if (rowItWasFound != -1) {
		    System.out.println(search.displayRecordFromHashtable(rowItWasFound));
		}
	}
	  
}
