
public class TestMyLinkedList2 
{
	public static void main(String[] args)
	{
		MyLinkedList<Person> list = new MyLinkedList<Person>();
		
		Person temp1 = new Person("Stan", "Lee", 88);
		list.add(temp1);
		System.out.println("(1) " + list);
		
		Person temp2 = new Person("Peter", "Park", 19);
		list.add(temp2);
		System.out.println("(2) " + list);
		
		Person temp3 = new Person("Gwenn", "Stacy", 20);
		list.add(temp3);
		System.out.println("(3) " + list);
		
		for (Person s: list)
			System.out.println(s.fName.toUpperCase() + " " + s.lName.toUpperCase());
		
		list.remove(0);
		System.out.println("(8) " + list);
		
		for (Person s: list)
			System.out.print(s.fName.toUpperCase() + " ");
		
		
		list.clear();
		
		System.out.println("\n After Clearing the list, the list size is "
				+ list.size());
	}
}
