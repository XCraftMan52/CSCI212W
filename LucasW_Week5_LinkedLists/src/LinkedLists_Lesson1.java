public class LinkedLists_Lesson1 
{
    static class Node
    {
        String data;
        Node next;

        Node(String data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Create Individual Nodes
        Node firstNode = new Node("Engine");
        Node secondNode = new Node("Minature Car");
        Node thirdNode = new Node("Passenger Car 1");
        Node fourthNode = new Node("Dinner Car");
        Node fifthNode = new Node("Passenger Car 2");
        Node sixthNode = new Node("Caboose");

        // Link nodes together. 
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        // Print linked list
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");

        System.out.println("\n** Moved some things around **\n");

         // Link nodes together. 
        firstNode.next = fourthNode;
        fourthNode.next = thirdNode;
        thirdNode.next = fifthNode;
        fifthNode.next = secondNode;
        secondNode.next = sixthNode;

        // Print linked list
        currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");


        System.out.println("\n** Now Let's add a payload of flowers car after passenger 2 **\n");

         // Link nodes together. 
        Node seventhNode = new Node("Flowers");
        fifthNode.next = seventhNode;
        seventhNode.next = secondNode;

        // Print linked list
        currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");

        System.out.println("\n** Now Let's provide a fresh breath to the caboose. **\n");

         // Link nodes together. 
        seventhNode.next = sixthNode;
        sixthNode.next = secondNode;
        secondNode.next = null;

        // Print linked list
        currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");

    }
}
