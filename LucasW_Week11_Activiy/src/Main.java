public class Main {
    

    private static void tryout(Actor actor) {
        actor.act();
    }
    

    public static void main(String[] args) {
        
        Actor1 actor1 = new Actor1();
        Actor2 actor2 = new Actor2();
        
        // Call the act method directly
        actor1.act();
        actor2.act();
        
        System.out.println();
        
        System.out.println("With Polymorphism");
        tryout(actor1);
        tryout(actor2);
        
        System.out.println();    
   }
}