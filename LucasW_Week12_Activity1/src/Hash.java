public class Hash 
{
    public int simple(String Key)
    {
        System.out.println("The Key is : " + Key);
        int len = Key.length();
        int sum = 0;
        for (int i = 0; i < len; i++)
        {
            int decVal = Key.charAt(i);
            sum = sum + decVal;
            System.out.println("Charecter " + (char)Key.charAt(i) + " = " + decVal);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        Hash hash = new Hash();
        int index = hash.simple("John Doe");
        System.out.println("Index number generated from key = " + index);
    }
}