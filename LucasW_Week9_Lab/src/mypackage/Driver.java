package mypackage;

public class Driver {

    public static void main(String[] args) {

        Queue waitingRoom = new Queue();

        waitingRoom.enqueue(new Patient("Alice Johnson", 34, "Chest pain"));
        waitingRoom.enqueue(new Patient("Bob Martinez", 52, "Broken wrist"));
        waitingRoom.enqueue(new Patient("Carol Lee", 28, "High fever"));
        waitingRoom.enqueue(new Patient("David Kim", 67, "Difficulty breathing"));
        waitingRoom.enqueue(new Patient("Eva Thompson", 19, "Severe headache"));

        // Display the full waiting room
        System.out.println();
        System.out.println("Current Waiting Room");
        System.out.println(waitingRoom);

        // Peek at the front patient 
        System.out.println();
        System.out.println("Next patient");
        Patient peeked = (Patient) waitingRoom.firstEl();
        System.out.println(peeked);

        // Two doctors are ready, dequeue two patients
        System.out.println();
        Patient called1 = (Patient) waitingRoom.dequeue();
        System.out.println("Now calling: " + called1);

        System.out.println();
        Patient called2 = (Patient) waitingRoom.dequeue();
        System.out.println("Now calling: " + called2);

        // Show updated queue after two dequeues
        System.out.println();
        System.out.println("Current Waiting Room");
        System.out.println(waitingRoom);

        // Drain every remaining patient
        System.out.println();
        System.out.println("Clearing remaining patients");
        while (!waitingRoom.isEmpty()) {
            Patient next = (Patient) waitingRoom.dequeue();
            System.out.println("Now calling: " + next);
        }

        // Confirm queue is empty
        System.out.println();
        System.out.println("Final status check");
        System.out.println("Is waiting room empty? " + waitingRoom.isEmpty());
    }
}