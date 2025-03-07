/**
 *  문제 이름 : 방 번호
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 0 ~ 9까지의 숫자 세트가 있다.
 *              이때 방 번호를 만드려고 할 때 세트가 최소하게 만드는 갯수를 구하여라
 *              (6은 9로 9는 6으로 대체가 가능하다.)
 * 
 *  해    설 : 6이랑 9를 처리하는 방법..이라...
 * 
 *              일단 6과 9가 들어오면 index 6번에 모두 더해준다.
 *              이후 최솟값을 비교하게 될 경우에는
 *              
 *              index 6번에 갯수를 가져온 뒤 %2를 하여 나머지가 1이라면 /2 몫나누기 + 1을 해주고
 *              아니라면 몫나누기 2만 해준다.
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

class B1475 {
    public static int solve(int num) {
        int arr[] = new int[9];
        int answer = 0;

        while (num > 0) { 
            int index = num%10;

            if(index == 6 || index == 9) 
                index = 6;

            arr[index]++;

            num /= 10;
        }


        for(int i = 0; i < 9; i ++) {
            int cmp = arr[i];

            if(i == 6) {
                if(cmp%2 == 1) {
                    cmp = cmp/2 + 1;
                } else {
                    cmp /= 2;
                }
            }

            if(cmp > answer) {
                answer = cmp;
            }
        }

        return answer;
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        output.write(String.valueOf(solve(num)));

        input.close();
        output.close();
    }
}