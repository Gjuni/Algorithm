/**
 *  문제 이름 : 수 정렬하기 4
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 내림차순으로 정렬하는 프로그램을 짜시오오
 * 
 *  해    설 : ArrayList를 쓰니 틀렸다고 나왔다. 왠지는 모르겠다...
 *              아마 Collections.reverse 때문인 것 같은데..
 * 
 *          그래서 array를 써서 구현했더니 맞았다. (진짜 왜지..?)
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

public class B11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        int[] array = new int[repeat_num];

        for (int i = 0; i < repeat_num; i++) {
            array[i] = (Integer.parseInt(input.readLine()));
        }

        Arrays.sort(array);

        for(int i = repeat_num-1; i >= 0; i--) {
            output.write(String.valueOf(array[i])+"\n");
        }
        
        input.close();
        output.close();
    }
}