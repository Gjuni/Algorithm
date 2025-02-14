
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1929 {
    public static int isPrime(int num) {
        if(num == 1) {
            return 0;
        }

        if(num == 2) {
            return 1;
        }

        for(int i = 2; i<= Math.sqrt(num); i++) {
            if(num%i == 0) {
                return 0;
            }
        }
        return 1;
    }
    
    public static void solve(int min_num, int max_num) {
        for(int i = min_num; i<= max_num; i++) {
            int answer = isPrime(i);
            
            if(answer == 1) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int min_num = Integer.parseInt(token.nextToken());
        int max_num = Integer.parseInt(token.nextToken());

        solve(min_num, max_num);

        input.close();
        output.close();
    }
}
