package mypackage;

public class AdvBubble {
	int[] data = {10,23,144,55,999,7,3,11,37,37};
	
	public int[] sort(int[] data) {
		
		int len = data.length;
		boolean swapped = true;
		int pass = 1;
		
		while (swapped && pass<len) {
			swapped = false;
			System.out.println("Pass = " + pass);
			
			for (int compares=0; compares<len-pass; compares++) {
				System.out.println(compares);
				if (data[compares] < data[compares+1]) {
					int temp = data[compares];
					data[compares] = data[compares+1];
					data[compares+1] = temp;
					
					swapped = true;
				}
			}
			if (!swapped) {
				System.out.println("Array is sorted early.");
			}
			pass++;
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
		AdvBubble bubble = new AdvBubble();
		bubble.printData();
		
		bubble.sort(bubble.data);
		
		System.out.println("The sorted order:");
		bubble.printData();
	}
}
