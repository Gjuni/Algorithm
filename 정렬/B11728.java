/**
 *  문제 이름 : 배열 합치기
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 합친 배열 정렬하는 문제
 * 
 *  해    설 : 그냥 합치고 정렬하셈
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

public class B11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        int array[] = new int[A+B];

        token = new StringTokenizer(input.readLine());
        for(int i =0 ;i < A; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(input.readLine());
        for (int i = A; i < A+B; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            output.write(String.valueOf(array[i])+" ");
        }

        input.close();
        output.close();
    }
}
