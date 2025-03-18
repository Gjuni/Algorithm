/**
 *  문제 이름 : 에라토스테네스의 체
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 1. 2부터 N까지 모든 정수를 적는다.
 *            2. 그 배수값끼리 수를 지워나간다.
 *             3. 지워진 수의 번째를 출력한다.
 * 
 *  해    설 : 
 * 
 *              중복된 수의 문제를 생각하지 못하였다.
 *              그래서 계속 이상한 값이 나왔고, 중복된 값은 넘어가게 Visit이라는 배열을 추가하여 문제를 해결하였다.
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

public class B2960 {
    static int arr[];
    static boolean visit[]; // 중복 방지

    public static int solve(int K, int N) {
        int index = 0;

        for (int i = 2; i <= K; i++) {
            for (int j = i; j <= K; j+=i) {
                if(visit[j] == false) {
                    visit[j] = true;
                    arr[index++] = j;
                }

                if(index == N) {
                    break;
                }   
            }

            if(index == N) {
                break;
            }       
        }
        return arr[index-1];
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int K = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        arr = new int[K+1];
        visit = new boolean[K+1];

        output.write(String.valueOf(solve(K, N)));

        input.close();
        output.close();
    }
}
