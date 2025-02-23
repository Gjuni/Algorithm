/**
 *  문제 이름 : 랜선 자르기
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
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
import java.util.StringTokenizer;

public class B1654 {
    public static int solve(int max_len, int need_count) {
        int answer = 0;


        return answer;
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int len_num = Integer.parseInt(token.nextToken());
        int need_count = Integer.parseInt(token.nextToken());

        int array[] = new int[len_num];

        for(int i = 0; i< len_num; i++) {
            int len = Integer.parseInt(input.readLine());

            array[i] = len;
        }

        input.close();
        output.close();
    }
}
