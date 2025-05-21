/**
 *  문제 이름 : 토너먼트
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 
 *              N명이 참가하는 토너먼트
 *              김지민과 임영웅이 토너먼트를 하는데
 *              몇 번째 라운드에서 만나는지 궁금하다. 구하라.
 * 
 *  해    설 : 
 *              김지민과 임영웅의 번호가 같아질 때까지 라운드 수를 증가시킨다.
 *              본인 번호 - (본인 번호/2) 를하여 순위를 줄이기 시작
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B1057 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        int answer = 0;

        while(K != L) {
            answer++;

            K -= K/2;
            L -= L/2;
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}