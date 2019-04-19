import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        ArrayList<Integer> toLoseContests = new ArrayList<>();

        int totalSum = 0;


        for(int i = 0 ; i < contests.length ; i++){
            int luck = contests[i][0];
            int importance = contests[i][1];

            if(importance == 0)
                totalSum += luck;

            if(importance == 1){
                toLoseContests.add(luck);

            }

            Collections.sort(toLoseContests, Collections.reverseOrder());
        }
        for(int i = 0 ; i < toLoseContests.size() ; i++){
            if(i <= k - 1){
                totalSum +=  toLoseContests.get(i);
            }
            else{
                totalSum -= toLoseContests.get(i);
            }
        }

        return totalSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        System.out.println(String.valueOf(result));


        scanner.close();


    }
}
