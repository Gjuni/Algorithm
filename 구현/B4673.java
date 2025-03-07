/**
 *  문제 제목 : 셀프 넘버
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 자기자신 수와 그 각 자기 수로 더해진 값은 셀프 넘버가 아니다.
 *              자기자신 수 + 각 자리수로 더해지지 않은 값은 셀프 넘버이다.
 * 
 *  해    설 : 
 *              자기자신 수 num 을 그대로 더해준 뒤
 *              각 자리수 만큼 더해주면 된다. 그 수가 존재하면 boolean배열에 true로 변경함
 *              true면 셀프 넘버가 아니라는 뜻
 * 
 *  시간 복잡도 : O(n*m)
 * 
 *  공간 복잡도 : O(n)
 *    
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4673 {
    // selfnum 이 아니면 true
    static boolean check[] = new boolean[10003];

    public static void solve(int i) {
        int num = i;

        while(i >= 1) {
            num += i%10;
            i /= 10;
        }

        check[num] = true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        // 이전 수들로 만들어지지 않는 애들이 self number

        // 이전 수들로 만들어진다면 self number가 아니다.
        for(int i = 1; i <= 9973; i++) {
            solve(i);
        }

        for(int i = 1; i <= 10000; i++) {
            if(check[i] == false) {
                output.write(String.valueOf(i)+"\n");
            }
        }

        input.close();
        output.close();
    }
}
