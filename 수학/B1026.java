/**
 *  문제 이름 : 보물
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 배열 A와 B가 있다.
 *              함수 S를 정의한다.
 *              S = A[0] x B[0] + .... + A[N-1] x B[N-1]
 * 
 *  해    설 : 배열 A는 내림차순으로 정렬
 *              배열 B는 오름차순으로 정렬렬
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
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1026 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int size_num = Integer.parseInt(input.readLine());

        StringTokenizer token1 = new StringTokenizer(input.readLine());
        StringTokenizer token2 = new StringTokenizer(input.readLine());

        int[] A = new int[size_num];
        int[] B = new int[size_num];

        for(int i =0; i < size_num; i++) {
            A[i] = Integer.parseInt(token1.nextToken());
            B[i] = Integer.parseInt(token2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] B_reverse = new int[size_num];
        
        for(int i = size_num-1; i >= 0; i--) {
            B_reverse[size_num-i-1] = B[i];
        }


        int result = 0;
        for(int i =0; i< size_num; i++) {
            result += (B_reverse[i] * A[i]);
        }



        output.write(String.valueOf(result));

        input.close();
        output.close();
    }
}
