import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        int sum = 0;

        int[] freq = new int[s.length()];

        for(int i = 0 ; i < s.length() ; i++){

            for(int j = 1 ; j <= Math.min(s.length()- 1  - i , i) ; j++){
                if(s.charAt(i-j) == s.charAt(i+j) && s.charAt(i-j) != s.charAt(i)){
                    if(j > 1){
                        System.out.println(j);
                        System.out.println(i);
                        if(s.charAt(i-j) != s.charAt(i-j+1) || s.charAt(i+j) != s.charAt(i+j-1)){
                            break;
                        }
                    }
                    System.out.println(s.charAt(i-j) +" " + s.charAt(i) + " " + s.charAt(i+j));
                    sum += 1;
                }
                else
                    break;
            }
        }

        int currentIndex = 0;

        freq[0] = 1;
        for(int j = 0 ; j < s.length() - 1 ; j++){
            if(s.charAt(j) == s.charAt(j+1)) {
                freq[currentIndex]++;

            }else{

                currentIndex++;
                freq[currentIndex]++;
            }
        }


        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i] != 0) {
                double avg = (double)(freq[i]+ 1) / (double)2;
                int total = (int) (avg * freq[i]);

                sum += total;
            }
        }

        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}