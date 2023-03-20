
public class March14 {

   public static void main(String[] args) {      
      System.out.println("" + palindrome("gabagoogabag"));
   }
   
   public static int factorial(int n) {
      if (n == 1)
         return 1;
         
      return n * factorial(n - 1);
   }

   public static int fibonacci(int n) {
      if (n == 0)
         return 0;
      if (n == 1)
         return 1;
      
      return fibonacci(n - 1) + fibonacci(n - 2);
   }

   public static String reverseStr(String input) {
      if (input.length() == 1)
         return input;
      
      String head = input.substring(0, 1);
      String tail = input.substring(1);
      return reverseStr(tail) + head;
   }

   public static boolean palindrome(String input) {
      if (input.length() == 1 || input.length() == 0)
         return true;
      
      String middle = input.substring(1, input.length() - 1);
      char first = input.charAt(0);
      char last = input.charAt(input.length() - 1);
      if (first == last)
         return palindrome(middle);

      return false;
   }
}