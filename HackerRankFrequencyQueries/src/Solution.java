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

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {


        HashMap<Integer,Integer> numberOccurence = new HashMap<>();

        HashMap<Integer,Integer> occurenceNumber = new HashMap<>();
        for(int i = 1 ; i <= 100000 ; i++){
            occurenceNumber.put(i,0);
        }

        List<Integer> resultList = new ArrayList<>();

        for(int i =0;  i < queries.size() ; i++){
            int type = queries.get(i)[0];
            int number = queries.get(i)[1];

            if(type == 1){
                if(!numberOccurence.containsKey(number)){
                    occurenceNumber.put(1, occurenceNumber.get(1) + 1);
                    numberOccurence.put(number,1);

                }else{
                    occurenceNumber.put(numberOccurence.get(number) + 1, occurenceNumber.get(numberOccurence.get(number) + 1) + 1);
                    occurenceNumber.put(numberOccurence.get(number), occurenceNumber.get(numberOccurence.get(number)) - 1);
                    numberOccurence.put(number, numberOccurence.get(number) + 1);

                }
            }
            else if(type == 2){
                if(numberOccurence.containsKey(number)){
                    if(numberOccurence.get(number) != 0) {
                        if(numberOccurence.get(number) - 1 != 0) {
                            occurenceNumber.put(numberOccurence.get(number) - 1, occurenceNumber.get(numberOccurence.get(number) - 1) + 1);
                            occurenceNumber.put(numberOccurence.get(number), occurenceNumber.get(numberOccurence.get(number)) - 1);
                        }
                        numberOccurence.put(number, numberOccurence.get(number) - 1);

                    }
                }
            }
            else if(type == 3){
                if(occurenceNumber.get(number) != 0){
                    resultList.add(1);
                }
                else{
                    resultList.add(0);
                }
            }
        }

        return resultList;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}
