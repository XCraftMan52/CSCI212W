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
	public int sequential(String keyToSearch) {
		System.out.println("Searching for " + keyToSearch + " using sequential method.");
		int i;
		for (i = 0; i < data.length; i++) {
			System.out.println("Read " + i + ", key= " + data[i][0]);
			if (keyToSearch.equalsIgnoreCase(data[i][0])) {
				break;
			}
		}
		if (i >= data.length) {
			i = -1;
			System.out.println("Key " + keyToSearch + " is not found.");
		} else {
			System.out.print("Key " + keyToSearch + " is found at index " + i);
			System.out.println(" after " + (i+1) + " reads.");
		}
		
		return i;
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
		int rowItWasFound = search.sequential("K9");
		System.out.println(search.displayRecord(rowItWasFound));
	}
	  
}
