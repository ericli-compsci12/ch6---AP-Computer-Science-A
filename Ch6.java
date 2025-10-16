import java.util.Scanner;
public class Ch6 {
    //main method(user input)
    public static void main (String[] args) {
     Scanner in = new Scanner(System.in);  
     System.out.println("Enter a choice:\n 1. PPAPFormatter\n 2. PalindromeDetector\n 3. BinaryConverter\n 4. PigLatinTranslater");
     String input = in.nextLine();
     if (input.equals("PPAPFormatter")) {
         System.out.print("Enter a sentence in \"I have a XXX, I have a XXX\" format:" );
         System.out.println(ppap(in.nextLine()));
     }
     else if (input.equals("PalindromeDetector")) {
         System.out.print("Enter a word, phrase or sentence: " );
         if (isPalindrome(in.nextLine())) System.out.println("It is a palindrome");
         else System.out.println("It is not a palindrome");
     }
     else if (input.equals("BinaryConverter")) {
         System.out.print("Enter a base 10 number: ");
         System.out.println("Binary Number: " + convertToBinary(in.nextInt()));
     }
     else if (input.equals("PigLatinTranslater")) {
         System.out.print("Enter a word: ");
         System.out.println("The word in pig latin is: " + pigLatin(in.nextLine()));
     }
         
    }
    
    
    //Assignment 1: PPAP
    public static String ppap(String str) {
        int comma_index = str.indexOf(",");
        int obj1_index = str.indexOf("a ") + 1; 
        int obj2_index = str.indexOf("a ", comma_index) + 2;
        String obj1 = str.substring(obj1_index, comma_index);
        String obj2 = str.substring(obj2_index);
        obj2 = obj2.substring(0,1).toUpperCase() + obj2.substring(1);
        return "Uh! " + obj2 + obj1 + ".";
    }
    
    
    //Assignment 2: isPalindrome
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        String nonLetters = ",.:;()[]{}!?></@#$%^&* "; 
        String str_f = "";
        String a = "";
        for (int i = 0; i < str.length(); i++) {
            if(nonLetters.contains(str.substring(i,i+1))) a = "";
            else a = str.substring(i,i+1);
            str_f = str_f + a;
        }
        str = str_f;
        String backward = "";
        for (int i = str.length(); i > 0; i--) {
            backward = backward + str.substring(i-1,i);
        }
        if (str.equals(backward)) return true;
        else return false;
    }
    
    //Assignment 3: convertToBinary
    public static String convertToBinary(int num) {
        int i = num;
        String rtn = "";
        while(i != 0) {
            rtn = i%2 + rtn ;
            i = i/2;
        }
        return rtn;
    }
    
    //Assignment 4: pigLatin
    public static String pigLatin(String msg) {
        return msg.substring(1) + msg.charAt(0) + "ay";
    }
}