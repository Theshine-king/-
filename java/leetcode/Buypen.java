package leetcode;
import java.io.*;


public class Buypen {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = (int) in.nval;
        int[][] arr = new int[3][2];
        for(int i = 0;i < 3;i++) {
            for(int j = 0;j < 2;j++) {
                arr[i][j] = (int) in.nval;
            }
        }
        out.println(buypencost(arr,n));
        out.flush();
        out.close();
    }



    public static int buypencost(int[][] arr,int n) {
        int cost1 = n / arr[0][0] + (n % arr[0][0] == 0 ? 0 : 1) * arr[0][1];
        int cost2 = n / arr[1][0] + (n % arr[1][0] == 0 ? 0 : 1) * arr[1][1];
        int cost3 = n / arr[2][0] + (n % arr[2][0] == 0 ? 0 : 1) * arr[2][1];
        return Math.min(cost1,Math.min(cost2,cost3));
    }
}