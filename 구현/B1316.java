/**
 *  문제 이름 : 분수 찾기
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : N!에서 0의 갯수를 구하는 프로그램을 작성
 * 
 *  해    설 : 처음에는 x0 의 갯수나 x00의 갯수를 세보려고 했으나
 *              10이나 100은 2*5로 만들어짐, 단 2는 5보다 많을 수 밖에 없기에 5의 갯수를 세면 되지 않을까 생각함
 *          -> 틀림
 * 
 *          해결책 : 
 *              
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

public class B1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());
        int answer = 0;

        for(int i = 1; i <= num; i++) {
            if(i%5 == 0) {
                answer++;
            }
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
