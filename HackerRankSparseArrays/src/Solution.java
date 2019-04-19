import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {

        if(strings.length < 1 || strings.length > 1000 || queries.length < 1 || queries.length > 1000){
            return null;
        }

        HashMap<String,Integer> queriesMap = new HashMap<>();
        for (String query : queries) {
            queriesMap.put(query,0);
        }

        for (String string : strings) {
            if(queriesMap.containsKey(string)){
                queriesMap.put(string,queriesMap.get(string) + 1);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = queriesMap.get(queries[i]);
        }

        return result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String a = "hello";
        int h = 1;
        a = a.substring(0,h) + a.substring(h+1);
        System.out.println(a.substring(0,0) + "rrrr");

        /*
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println((String.valueOf(res[i])));

            if (i != res.length - 1) {
                System.out.println(("\n"));
            }
        }

        String a = "hello";
        int h = 2;
        a = a.substring(0,h) + a.substring(h+1);
        System.out.println(a);



        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();

         */
    }
}
