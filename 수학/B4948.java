/**
 *  문제 이름 : 베르트랑 공준
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 :  베르트랑 공준은
 *              임의의 자연수 n보다 크고 2n보다 작거나 같은 소수는 적어도 하나는 존재
 * 
 *  해    설 : 에라스토테네스의 체를 사용하여 미리 소수인 수를 제거한 후 계산하도록 게산하였다.
 *             원하는 수 만큼 배열을 햘당하여 소수를 미리 지우고 계산하여 풀었다.
 * 
 *              i가 2부터 시작하여 i의 i+i부터 시작하면서 i의 값을 계속 더하면서 소수가 아닌 수를 1로 변경한 후 
 *              0이면 소수로 계산하여 풀어나아갔다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4948 {
    static int[] prime_array = new int[246913];

    public static void fill_prime_num() {
        prime_array[1] = 1;
        prime_array[2] = 0;

        for(int i =2; i < 246913; i++) {
            if(prime_array[i] == 1) {
                continue;
            }

            for(int j = i*2; j <= 246913; j+= i) {
                prime_array[j] = 1;
            }
        }
    }


    public static int solve(int num) {
        int answer = 0;

        int start_num = num;
        int end_num = num*2;

        for(int i = start_num+1; i <= end_num; i++) {
            if(prime_array[i] == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));


        fill_prime_num();
    
        while(true) {
            int start_num = Integer.parseInt(input.readLine());

            if(start_num == 0) {
                break;
            }

            int result = solve(start_num);
            output.write(String.valueOf(result)+"\n");
        }

        input.close();
        output.close();
    }
}
