import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //f
    //APZNC

    //MXCXHIBQFIXTJMHURXCHHKVHUtfydvznieoivbuflfvsyfizoffajspejbagwxsmaxkp
    //MXCXHIBQFIXTJMHURXCHHKVHU


    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        
        HashSet<Character> aSet = new HashSet<>();

        for(int i = 0 ; i< a.length() ; i++){
            aSet.add(a.charAt(i));
        }
        
        for(int i = 0 ; i < b.length() ; i++){
            
            if(aSet.contains(b.charAt(i)) ){
                aSet.remove(b.charAt(i));
            }
            else if(aSet.contains(Character.toLowerCase(b.charAt(i)))){
                aSet.remove(Character.toLowerCase(b.charAt(i)));
            }
            else{
                return "NO";
            }
            

        }

        Iterator<Character> it = aSet.iterator();
        while(it.hasNext()){

            if(!isLowerCase(it.next())){
                return "NO";
            }
        }
        return "YES";
        
        /*
        String regex = "";
        for(int i = 0 ; i < b.length() ; i++){
            regex += "[a-z]*" + "[" + b.charAt(i) + "|" + Character.toLowerCase(b.charAt(i)) + "]";
        }
        regex  += "[a-z]*";
        Pattern ptrn = Pattern.compile(regex);
        Matcher matcher = ptrn.matcher(a);

        return matcher.matches() ? "YES" : "NO";
*/
        
        /*
        int aPtr = 0;

        //b e F g H
        //  E F   H
        for(int i = 0 ; i < b.length() ; i++){

            if(aPtr + 1 >= a.length())
                return "NO";
            //if(aPtr + 1 == a.length() && i + 1 == b.length())
            //    return "YES";

            System.out.println(b.charAt(i) + "  "  + a.charAt(aPtr));
            if(b.charAt(i) == a.charAt(aPtr)){
                aPtr++;
            }else if(b.charAt(i) == Character.toUpperCase(a.charAt(aPtr)) && isLowerCase(a.charAt(aPtr))){
                aPtr++;

            } else if(b.charAt(i) != a.charAt(aPtr) && !isLowerCase(a.charAt(aPtr))){
                return "NO";
            }else if(b.charAt(i) != a.charAt(aPtr) && isLowerCase(a.charAt(aPtr))){
                aPtr++;
                i--;
            }



        }
        for(int i = aPtr ; i < a.length() ; i++){
            if(!isLowerCase(a.charAt(i)))
                return "NO";
        }

        return "YES";
        */

    }

    public static boolean isLowerCase(char c){
        if(c - Character.toLowerCase(c) != 0)
            return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            System.out.println(result);

        }



        scanner.close();
    }
}
