
import java.util.Scanner;
import java.io.*;
public class Video_020_price {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int price = in.nextInt();
       float lastPrice = getPrice(price);
       System.out.println(lastPrice);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//导入文件
        // StreamTokenizer in = new StreamTokenizer(br);//一个一个的读取答案
        // PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
        // while (in.nextToken() != StreamTokenizer.TT_EOF) {
        //     int money = (int)in.nval;
        //     in.nextToken();
        // }    
    
    }
    public static float getPrice(int money) {
        if(money >= 100 && money < 500) {
            money *= 0.9; 
        }
        if(money >= 500 && money < 2000) {
            money *= 0.8;
        }
        if(money >= 2000 && money < 5000) {
            money *= 0.7;
        }    
        if(money >= 5000) {
            money *= 0.6;
        }
        return money;
    }
}
