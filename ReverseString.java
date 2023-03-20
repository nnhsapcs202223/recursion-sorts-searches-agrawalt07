
/**
 * Write a description of class reverseString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReverseString
{
    public static String reverse(String str){
        //code the termination condition, base case
        if(str.equals("")){
            return str; 
        }
        String firstChar = str.substring(0,1); 
        String restOfSubstring = str.substring(1); 
        
        String reversed = reverse(restOfSubstring);
        restOfSubstring += firstChar; 
        
        return reversed;
    }
    
    public static String reverseItr(String str){
        String reverseStr = "";
        
        for(int i = str.length()-1; i>=0; i--){
            reverseStr += str.substring(i,i+1); 
        }
        System.out.println(reverseStr);
        return reverseStr; 
    }
}
