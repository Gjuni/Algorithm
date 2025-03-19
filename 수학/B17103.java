/**
 *  문제 이름 : 골드바흐 파티션션
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 골드바흐의 추측 : 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 
 *              두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 함.
 *              두 소수의 순서만 다른 것은 같은 파티션. (3, 17) == (17, 3)
 * 
 *  해    설 : 
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

public class B17103 {
    static int[] arr;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());


        for(int i =0; i< repeat_num; i++) {
            
        }

        input.close();
        output.close();
    }
}
