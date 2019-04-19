import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        if(s.length() == 1)
            return "YES";
        HashMap<Character, Integer> letterNumbers = new HashMap<>();

        for (Character letter : s.toCharArray()) {
            if(!letterNumbers.containsKey(letter))
                letterNumbers.put(letter,0);
            letterNumbers.put(letter, letterNumbers.get(letter) + 1);
        }

        System.out.println(letterNumbers);
        HashMap<Integer, Integer> numberNumbers = new HashMap<>();

        for (int i = 0; i < letterNumbers.keySet().size(); i++) {
            Character letterNumberKey = (Character) letterNumbers.keySet().toArray()[i];
            Integer letterNumberValue = letterNumbers.get(letterNumberKey);

            if(!numberNumbers.containsKey(letterNumberValue))
                numberNumbers.put(letterNumberValue,0);

            numberNumbers.put(letterNumberValue, numberNumbers.get(letterNumberValue ) + 1);
        }

        System.out.println(numberNumbers);

        if (numberNumbers.keySet().size() == 1)
            return "YES";
        if (numberNumbers.keySet().size() == 2) {

            Integer numberKey0 = (Integer) numberNumbers.keySet().toArray()[0];
            Integer numberKey1 = (Integer) numberNumbers.keySet().toArray()[1];
            //Integer[] numberKeyArray = (Integer[]) numberNumbers.keySet().toArray();
            //Integer numbervalue = numberNumbers.get(numberKeyArray);

            int maxKey = Math.max(numberKey0, numberKey1);
            if (maxKey == 1) {

                return "YES";
            }

            int minKey = Math.min(numberKey0,numberKey1);
            if (minKey == 1 && numberNumbers.get(minKey) == 1) {

                return "YES";
            }

            if(maxKey - minKey == 1 && numberNumbers.get(maxKey) == 1)
                return "YES";


        }

        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println((result));

        scanner.close();
    }
}
