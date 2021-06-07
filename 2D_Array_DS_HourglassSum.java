import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    int i;
    int j;
    int a;
    int max;
    List<Integer> res = new ArrayList<>();
    
    for(i=0;i<=3;i++)
    {
        for(j=1;j<=4;j++)
        {
            a=arr.get(i).get(j-1)+arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i+1).get(j)+arr.get(i+2).get(j-1)+arr.get(i+2).get(j)+arr.get(i+2).get(j+1);
            res.add(a);
        }
    }
    int k;
    max=res.get(0);
    for(k=1;k<res.size();k++)
    {
        if(res.get(k)>max)
        {
            max=res.get(k);
        }
    }
    return max; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

