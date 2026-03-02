public class TestMyLinkedList3 
{
	public static void main(String[] args)
	{
		MyLinkedList<Car> list = new MyLinkedList<Car>();
		
		Car temp1 = new Car("Toyota", "Camry", 2020, 2.5, true);
		list.add(temp1);
		System.out.println("(1) " + list);
		
		Car temp2 = new Car("Ford", "Mustang", 2019, 5.0, false);
		list.add(temp2);
		System.out.println("(2) " + list);
		
		Car temp3 = new Car("Honda", "Civic", 2022, 1.5, true);
		list.add(temp3);
		System.out.println("(3) " + list);
		
		for (Car c: list)
			System.out.println(c.cMake.toUpperCase() + " " + c.cModel.toUpperCase());
		
		list.remove(0);
		System.out.println("(8) " + list);
		
		for (Car c: list)
			System.out.print(c.cMake.toUpperCase() + " ");
		
		 Car temp4 = new Car("Chevy", "Malibu", 2018, 2.0, true);
	     temp4.setYear(2021); // update year using setter
	     list.add(temp4);
	     System.out.println("\nAfter adding updated car: " + list);
	        
		list.clear();
		
		System.out.println("\n After Clearing the list, the list size is "
				+ list.size());
	}
}