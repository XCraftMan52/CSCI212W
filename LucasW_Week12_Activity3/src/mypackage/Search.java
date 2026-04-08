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
	public int binary(String keyToSearch) {
		System.out.println("Searching for " + keyToSearch + " using binary method.");
		int len = data.length;
		int tries = 0;
		int upper = len;
		int foundAtIndex = -1;
		int lower = 0;
		
		while (lower <= upper) {
		    int index = (lower + upper) / 2;          // middle
		    System.out.println("Read " + index + ", key= " + data[index][0]);
		    tries++;

		    int compare = keyToSearch.compareToIgnoreCase(data[index][0]);

		    if (compare == 0) {
		        foundAtIndex = index;
		        break;
		    } else if (compare > 0) {
		        lower = index + 1;                 
		    } else {
		        upper = index - 1;                    
		    }
		}
		
		if (foundAtIndex == -1) {
			System.out.println("Key " + keyToSearch + " is not found.");
		} else {
			System.out.print("Key " + keyToSearch + " is found at index " + foundAtIndex);
			System.out.println(" after " + tries + " reads.");
		}
		
		return foundAtIndex;
	}
	
	
	public String displayRecord(int index) {
		return "Record = "
				+ data[index][0]
				+ ", "
				+ data[index][1]
				+ ", "
				+ data[index][2]
				+ ", "
				+ data[index][3];
	}
	public static void main(String[] args) {
		Search search = new Search();
		int rowItWasFound = search.binary("K1");
		System.out.println(search.displayRecord(rowItWasFound));
	}
	  
}
