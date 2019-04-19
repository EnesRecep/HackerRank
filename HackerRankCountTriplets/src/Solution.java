import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        HashMap<Long, Long> numbers = new HashMap<>();
        long sum = 0;

        for (Long aLong : arr) {
            if(!numbers.containsKey(aLong)){
                numbers.put(aLong,1L);
            }else{
                numbers.put(aLong, numbers.get(aLong) + 1);
            }
        }

        Object[] numbersArray = numbers.keySet().toArray();
        for(int i = 0 ; i < numbers.size() ; i++){
            Long currentNumberKey = (Long)numbersArray[i];
            Long currentNumberValue = (Long) numbers.get(currentNumberKey);

            if(r == 1){
                sum += combination(numbers.get(currentNumberKey),3);
            }else {

                if (currentNumberKey != 0) {
                    if (numbers.containsKey(currentNumberKey * r) && numbers.containsKey(currentNumberKey * r * r)) {
                        long toAdd = numbers.get(currentNumberKey) * numbers.get(currentNumberKey * r) * numbers.get(currentNumberKey * r * r);

                        sum += toAdd;
                    }
                }
            }
        }

        return sum;

    }

    public static long combination(long n , long r){
        System.out.println("factorial("+n+") / (factorial("+r+") * factorial("+ (n-r) +"));");
        System.out.println(factorial(r));
        System.out.println(factorial(n-r));
        return factorial(n) / (factorial(r) * factorial(n-r));
    }

    public static long factorial(long number){
        long fact = 1l;
        for(long i=1;i<=number;i++){
            fact=fact*i;
        }

        return fact;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));


        bufferedReader.close();

    }
}
