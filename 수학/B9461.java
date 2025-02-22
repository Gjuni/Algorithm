/**
 *  문제 이름 : 파도반 수열
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 수열 값 구하는 로직
 *              1 1 1 2 2 3 4 5 7 9 12
 * 
 *  해    설 : P[n] = P[n-2] + P[n-3]
 *             P[n] = P[n-1] + P[n-5]
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

public class B9461 {
    static long[] array;

    public static long solve(int num) {
        if(num <= 3) {
            return array[1];
        }else if (num > 4 && num < 6) {
            return 2;
        }

        for(int i = 5; i<= num; i++) {
            array[i] = array[i-2] + array[i-3];
        }

        return array[num];
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        array = new long[101];

        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 2;

        for(int i =0; i< repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());

            output.write(String.valueOf(solve(num))+"\n");
        }

        

        input.close();
        output.close();
    }
}
