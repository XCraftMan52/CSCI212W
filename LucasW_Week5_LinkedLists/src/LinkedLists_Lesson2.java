public class LinkedLists_Lesson2 
{
    static class Node
    {
        String name;
        int grade;
        Node next;

        public Node(String name, int grade)
        {
            this.name = name;
            this.grade = grade;
            this.next = null;
        }
    }

    public static void traverseAndPrint(Node head) {
        // Create Individual Nodes
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.name + " (" + currentNode.grade + ") -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static Node insertNodeAtPosition(Node head, Node newNode, int position)
    {
        if (position == 1)
        {
            newNode.next = head;
            return newNode;
        }

        Node currentNode = head;
        for (int i = 1; 1 < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode != null)
        {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        return head;
    }

    public static Node deleteSpecifiedNode(Node head, Node nodeToDelete)
    {
        if (head == nodeToDelete) {
            return head.next;
        }

        Node currentNode = head;
        while (currentNode.next != null && currentNode.next != nodeToDelete)
        {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null)
        {
            return head;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    public static int findLowestValue(Node head)
    {
        int minValue = head.grade;
        Node currentNode = head.next;

        while (currentNode != null)
        {
            if (currentNode.grade < minValue)
            {
                minValue = currentNode.grade;
            }
            currentNode = currentNode.next;
        }
        return minValue;
    }

    public static void main(String[] args)
    {
        Node node1 = new Node("Scott", 87);
        Node node2 = new Node("Jen", 97);
        Node node3 = new Node("Carl", 94);
        Node node4 = new Node("Cathly", 89);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Original List (1,2,3,4):");
        traverseAndPrint(node1);

        Node newNode = new Node("Steph", 98);
        node1 = insertNodeAtPosition(node1, newNode, 2);

        System.out.println("\nAfter Insertion:");
        traverseAndPrint(node1);

        node1 = deleteSpecifiedNode(node1, node3);

        System.out.println("\nAfter Deletion:");
        traverseAndPrint(node1);

        System.out.println("The lowest value in the list is:" + findLowestValue(node1));

    }
}
