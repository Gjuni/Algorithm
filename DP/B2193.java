/**
 *  문제 이름 : 이친수
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 *              1. 0으로 시작하지 않는다.
 *              2. 1이 두번 연속 나오지 않는다. 11을 부분 문자열을 가지지 않는다.
 * 
 *  해    설 : 
 *          이친수 갯수
 *          1 = 1
 *          2 = 1
 *          3 = 2
 *          4 = 3
 *          5 = 5  10000 10001 10101 10100 10010
 *          6 = 8  100000 101000 100100 100010 100001 101010 101001 100101
 *          
 *          100일 때 이친수가 3736710778780434371 쉬벌 존나 많음
 *          int값(2147483647)으로는 커버가 불가능 Long Type을  써서 해결
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */

import java.io.*;

public class B2193 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] arr;

    public static long solve(int len) {
        if(len == 1) {
            return 1;
        } else if(len == 2) {
            return 1;
        } else {
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i < len; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }

        return arr[len-1];
    }

    public static void main(String argc[]) throws IOException{
        int len = Integer.parseInt(input.readLine());

        arr = new long[len+1];

        output.write(String.valueOf(solve(len)));

        input.close();
        output.close();
    }
}