/**
 *  문제 이름 : 수 정렬하기 5
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 비내림차순으로 정렬하는 프로그램을 작성하시오
 *              비내림차순이란? 
 *                  A1 <= A2 <= A3 ... 
 * 
 *  해    설 : 그냥 배열 정렬하면 됨;;
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

public class B15688 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        int arr[] = new int[repeat_num];

        for (int i = 0; i < repeat_num; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < repeat_num; i++) {
            output.write(String.valueOf(arr[i])+"\n");
        }

        input.close();
        output.close();
    }
}
