public class PlayerSorting {

    static class Player {
        private String name;
        private int age;

        public Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void bubbleSort(Player[] playerList, boolean ascending, boolean sortByName) {
        int n = playerList.length;
        int pass = 0;
        boolean swapped = true;

        long start = System.nanoTime();

        while (pass < n - 1 && swapped) {
            swapped = false; 

            for (int j = 0; j < n - pass - 1; j++) {
                boolean needSwap = false;

                if (sortByName) {
                    int cmp = playerList[j].getName().compareToIgnoreCase(playerList[j + 1].getName());
                    needSwap = ascending ? (cmp > 0) : (cmp < 0);
                } else {
                    needSwap = ascending ? (playerList[j].getAge() > playerList[j + 1].getAge())
                                         : (playerList[j].getAge() < playerList[j + 1].getAge());
                }

                if (needSwap) {
                    Player temp = playerList[j];
                    playerList[j] = playerList[j + 1];
                    playerList[j + 1] = temp;
                    swapped = true;
                }
            }

            pass++;
        }

        long end = System.nanoTime();
        System.out.println("Bubble sort finished in " + (end - start) + " ns");
    }

    public static void insertionSort(Player[] playerList, boolean ascending, boolean sortByName) {
        int n = playerList.length;

        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            Player key = playerList[i];
            int j = i - 1;

            boolean shouldMove = true;
            while (j >= 0 && shouldMove) {
                if (sortByName) {
                    int cmp = playerList[j].getName().compareToIgnoreCase(key.getName());
                    shouldMove = ascending ? (cmp > 0) : (cmp < 0);
                } else {
                    shouldMove = ascending ? (playerList[j].getAge() > key.getAge())
                                           : (playerList[j].getAge() < key.getAge());
                }

                if (shouldMove) {
                    playerList[j + 1] = playerList[j]; 
                    j--;
                }
            }

            playerList[j + 1] = key;
        }

        long end = System.nanoTime();
        System.out.println("Insertion sort finished in " + (end - start) + " ns");
    }

    public static void printPlayers(Player[] playerList) {
        for (Player p : playerList) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	Player[] playerList = new Player[10];

    	playerList[0] = new Player("Larry", 28);
    	playerList[1] = new Player("Gregory", 34);
    	playerList[2] = new Player("Steve", 22);
    	playerList[3] = new Player("John", 30);
    	playerList[4] = new Player("Jane", 25);
    	playerList[5] = new Player("Joseph", 29);
    	playerList[6] = new Player("Abraham", 31);
    	playerList[7] = new Player("Jaime", 27);
    	playerList[8] = new Player("Max", 19);
    	playerList[9] = new Player("Lucas", 12);


        System.out.println("Original list:");
        printPlayers(playerList);

        // sort by age ascending
        bubbleSort(playerList, true, false);
        System.out.println("Bubble Sort by age ascending:");
        printPlayers(playerList);

        // sort by age ascending
        insertionSort(playerList, true, false);
        System.out.println("Insertion Sort by age ascending:");
        printPlayers(playerList);

        // sort by name descending
        bubbleSort(playerList, false, true);
        System.out.println("Bubble Sort by name descending:");
        printPlayers(playerList);

        // sort by age descending
        bubbleSort(playerList, false, false);
        System.out.println("Bubble Sort by age descending:");
        printPlayers(playerList);

    }
}