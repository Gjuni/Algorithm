/**
 *  문제 이름 : 날짜 계산
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19) 일 때
 *            E S M의 값이 될 때까지 몇년이 걸리는지 계산하라
 * 
 *  해    설 : (!(E == temp_E && S == temp_S && M == temp_M)) 랑
 *             (E != temp_E && S != temp_S && M != temp_M) 의 차이가 뭐임??
 * 
 *              1번의 경우에는 3값이 모두 다른 경우에 작동
 *              2번의 경우 모든 값이 다를 때만 True... 하나라도 같으면 False가 뜬다. ㅇㅎ
 *          
 *              2번의 경우 (E != temp_E || S != temp_S ||| M != temp_M) 으로  수정해야함.
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

public class B1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int E = Integer.parseInt(token.nextToken()); // 1 - 15
        int S = Integer.parseInt(token.nextToken()); // 1 - 28
        int M = Integer.parseInt(token.nextToken()); // 1 - 19

        int index = 1;
        int temp_E = 1;
        int temp_S = 1;
        int temp_M = 1;

        while (!(E == temp_E && S == temp_S && M == temp_M)) { 
            index++;
            temp_E++;
            temp_M++;
            temp_S++;
            
            if(temp_E > 15) {
                temp_E = 1;
            }

            if(temp_S > 28) {
                temp_S = 1;
            }

            if(temp_M > 19) {
                temp_M = 1;
            }
        }

        output.write(String.valueOf(index));


        input.close();
        output.close();
    }
}
