/**
 *  문제 이름 : 다리 놓기기
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 :  서쪽 포인트 N
 *             동쪽 포인트 M 이 존재 할 때 N <= M
 *             곂치지 않게 다리를 만들 수 있는 경우의 수를 구하여라
 * 
 *             조합...? 비트마스킹?
 * 
 *             M - N 한 후 M의 수  -1 씩 N번 --  이거 아님
 *             
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

public class B1010 {
    public static int solve(int west, int east) {
        int answer = 1;

        int count_num = east - west;

        // 설치 방법이 단 1가지만 존재재
        if(count_num == 0) {
            return answer;
        }

        for(int i =1; i<= west; i++) {
            answer *= east;
            east--;
        }
        return answer;
    }   

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0 ; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int west = Integer.parseInt(token.nextToken());
            int east = Integer.parseInt(token.nextToken());

            output.write(solve(west, east)+"\n");
        }

        input.close();
        output.close();
    }
}
