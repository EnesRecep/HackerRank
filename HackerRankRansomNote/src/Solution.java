import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String,Integer> magazineWords = new HashMap<>();

        for(int i = 0 ; i < magazine.length ; i++){
            if(!magazineWords.containsKey(magazine[i])){
                magazineWords.put(magazine[i],1);
            }else
                magazineWords.put(magazine[i], magazineWords.get(magazine[i]) + 1);
        }

        for(int i = 0 ; i < note.length ; i++){
            if(!magazineWords.containsKey(note[i]) ){
                System.out.println("No");
                return;
            }
            else if(magazineWords.get(note[i]) < 1){
                System.out.println("Noo");
                return;
            }
            else{
                magazineWords.put(magazine[i], magazineWords.get(note[i]) - 1);
                System.out.println("Removing " + note[i]);
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
