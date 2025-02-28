/**
 *  문제 이름 : 골드바흐의 추측
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 :   n이 주어졌을 때 n = a + b를 소수들로 나타낼 수 있다.
 *              소수의 합으로 나타낼 수 있는지 증명하라
 *              만약 여러 case가 존재한다면
 *              b-a가 가장 큰 수로 나타내라
 *              
 *              만약 나타낼 수 없다면
 *              Goldbach's conjecture is wrong. 을 출력
 * 
 *  해    설 :  간단한 에라스토테네스의 체 알고리즘이다.
 *              문제는 sovle에서 최적화인데
 *          
 *              여러 경우가 존재할 때 b -a 가 최소인 경우에 결과를 출력하라고 했으니
 *              a가 가장 작은 경우를 세면 된다.
 *              
 *              그렇기에 for문 1번으로 최적화 돌릴 수 있다.
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

public class B6588 {
    static int array[] = new int[1000001];

    // 에라스토테네스의 체
    public static void find_decimal() {
        array[1] = 1;
        array[2] = 0;

        for(int i = 2; i<= Math.sqrt(1000000); i++) {
            for(int j = i*i; j <= 1000000; j+=i) {
                if(array[j] == 1) continue;

                array[j] = 1;
            }
        }
    }

    public static void solve(int num, BufferedWriter output) throws IOException{
        int a = 0;
        int b = 0;
        int check = 0;

        for(int i = 2; i <= num; i++) {
            a = i;
            b = num - i;
            
            if(array[a] == 0 && array[b] == 0) {
                output.write(String.valueOf(num)+" = "+String.valueOf(a)+" + "+String.valueOf(b)+"\n");
                return;
            }
        }

        output.write("Goldbach's conjecture is wrong.\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 100;

        find_decimal();

        while(true) {
            num = Integer.parseInt(input.readLine());

            if(num == 0) {
                break;
            }

            solve(num, output);
        }

        input.close();
        output.close();
    }
}
