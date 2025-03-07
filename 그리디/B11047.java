
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class B11047 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int money_count = Integer.parseInt(token.nextToken());
        int total_money = Integer.parseInt(token.nextToken());

        int[] money_array = new int[money_count];

        for(int i = money_count-1; i >= 0; i--) {
            money_array[i] = Integer.parseInt(input.readLine());
        }

        int answer_count = 0;
        int index =0;

        while (total_money > 0) { 
            if(total_money >= money_array[index]) {
                total_money -= money_array[index];
                answer_count++;
            } else {
                index++;
            }
        }   

        output.write(String.valueOf(answer_count));

        input.close();
        output.close();
    }    
    
}
