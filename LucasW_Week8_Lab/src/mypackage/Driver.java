package mypackage;

public class Driver {
    public static void main(String[] args) {

        LLStack stack = new LLStack();

        Sound s1 = new Sound("Thunder", 4.5);
        Sound s2 = new Sound("Rain", 8.2);
        Sound s3 = new Sound("Gravel", 3.1);
        Sound s4 = new Sound("Ocean", 6.7);
        Sound s5 = new Sound("Sand", 5.0);

        stack.push(s1); 
        stack.push(s2); 
        stack.push(s3); 
        stack.push(s4);
        stack.push(s5);

        stack.pop();
        stack.pop();

        Sound top = (Sound) stack.topEl();
        System.out.println("Top element: ");
        System.out.println("  Sound Name:   " + top.getSoundName());
        System.out.println("  Sound Length: " + top.getSoundLength() + "s");
    }
}