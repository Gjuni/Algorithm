import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1002 {
    public static int solve(int x_1, int y_1, int r_1, int x_2, int y_2, int r_2) {
        double pow_for_distacne_x = Math.pow((x_1-x_2), 2);
        double pow_for_distacne_y = Math.pow((y_1-y_2), 2);
        
        double total_distace = pow_for_distacne_x + pow_for_distacne_y;
        double round = Math.pow(r_1+r_2, 2);
        double round_inner = Math.pow(r_1-r_2, 2);

        if(total_distace == 0) { // 둘의 원점이 동일 할 시
            if(r_1 == r_2) // 반지름도 동일할 시 무한 교점
                return -1;
            else 
                return 0; // 반지름이 동일하지 않으면 교점이 없음
        } 

        // 둘의 원점이 동일하지 않음
        if(total_distace < round_inner) {
            return 0;
        } else if(total_distace == round_inner) {
            return 1;
        } else if(total_distace < round) {
            return 2;
        } else if(total_distace == round) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int x_1 = Integer.parseInt(token.nextToken());
            int y_1 = Integer.parseInt(token.nextToken());
            int r_1 = Integer.parseInt(token.nextToken());
            int x_2 = Integer.parseInt(token.nextToken());
            int y_2 = Integer.parseInt(token.nextToken());
            int r_2 = Integer.parseInt(token.nextToken());

            int result = solve(x_1, y_1, r_1, x_2, y_2, r_2);
            output.write(String.valueOf(result)+"\n");
        }

        input.close();
        output.close();
    }
}
