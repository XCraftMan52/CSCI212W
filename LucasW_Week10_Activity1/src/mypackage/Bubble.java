package mypackage;

public class Bubble {
	int[] data = {10,23,144,55,999,7,3,11,37,37};
	
	public int[] sort(int[] data) {
		
		int len = data.length;
		
		for (int pass=1; pass<len; pass++) {
			System.out.println("Pass = " + pass);
			for (int compares=0; compares<len-pass; compares++) {
				System.out.println(compares);
				if (data[compares] < data[compares+1]) {
					int temp = data[compares];
					data[compares] = data[compares+1];
					data[compares+1] = temp;
				}
			}
		}
		return data;
	}
	public void printData() {
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("The unsorted order:");
		Bubble bubble = new Bubble();
		bubble.printData();
		
		bubble.sort(bubble.data);
		
		System.out.println("The sorted order:");
		bubble.printData();
	}
}
