import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11659 {
    public static int solve(int start, int end, int[] preFix) {
        int answer = 0;

        answer = preFix[end] - preFix[start-1];

        return answer;
    }   
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int array_len = Integer.parseInt(token.nextToken());
        int repeat_num = Integer.parseInt(token.nextToken());

        int[] array = new int[array_len+1];
        int[] preFix = new int[array_len+1];
        
        token = new StringTokenizer(input.readLine());

        for(int i =1; i<= array_len; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            preFix[i] += preFix[i-1]+array[i];
        }

        
        for(int i =0; i< repeat_num; i++) {
            token = new StringTokenizer(input.readLine());
            
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            int result = solve(start, end, preFix);

            output.write(String.valueOf(result)+"\n");
        }

        input.close();
        output.close();
    }    
}
