/**
 *  문제 이름 : 아무래도 이 문제는 A번 난이도 인 것 같다.
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : A = a1 * a2 * a3 * . . . an 으로 했을 때
 *              A' = a1 + a2 + a3 + . . . an 이 성립하면
 *              A는 A'으로 변할 수 있다 라고 한다.
 *              
 *              A와 B가 주어졌을 때 
 *              A는 B로 변할 수 있는지 판별하라
 * 
 *  해    설 : 문제의 헛점
 *              A가 주어졌을 때 A = -1 * -1 * ... n이든
 *              B가 어떤 수이든 간에 A가 1과 -1로 만들 수 있다... 즉 모두 YES
 *              
 *              소인수분해인줄 알고 했다가 헛고생만 했다.
 * 
 *              예를 들어 A가 6, B가 5라면
 *              A = 1 * 6 * -1 * -1
 *              B = 1 + 6 -1 -1 이기에 충족이 된다..
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

public class B1402 {
    public static boolean solve(int A, int B) {
        boolean answer = true;
        return answer;
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0 ; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            
            output.write("yes"+"\n");
        }

        input.close();
        output.close();
    }
}
