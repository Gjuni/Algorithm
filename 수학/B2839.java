import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class B2839 {
    public static int solve(int total_kg, int num) {
        if(total_kg%5 == 0) {
            num = total_kg/5;
            return num;
        } else {
            // 5로 안나눠졌기 때문에 3씩 빼면서 count
            while(total_kg > 0) {
                total_kg -= 3;
                num++;

                if(total_kg == 0) {
                    return num;
                }

                if(total_kg%5 == 0) {
                    num += total_kg/5;
                    total_kg %= total_kg/5;
                }
            }
            if(total_kg < 0) {
                num = -1;
            }
        }
        return num;
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int total_kg = Integer.parseInt(input.readLine());
        
        int result = solve(total_kg, 0);

        output.write(String.valueOf(result));
        input.close();
        output.close();
    }
}
