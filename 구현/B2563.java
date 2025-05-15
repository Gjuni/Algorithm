/**
 *  문제 이름 : 색종이
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 가로, 세로 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
 *              가로, 세로의 길이가 10인 색종이를 붙이려고 한다. 
 *              색종이가 붙혀진 면적을 구하여라.
 * 
 *  해    설 : 수학적으로 계산하지 않고 그냥 2차원 배열 선언해서 칠하면 끝이었던 문제임...
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.StringTokenizer;

public class B2563 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int area[][] = new int[101][101];

        int num = Integer.parseInt(input.readLine());

        for (int i = 0; i < num; i++) {
            
            StringTokenizer token = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            
            for(int m = y; m < y+10; m++) {
                for(int n = x; n < x+10; n++) {
                    area[m][n] = 1;
                }
            }
        }

        int answer = 0;

        for(int n = 1; n <= 100; n++) {
            for(int m = 1; m <= 100; m++) {
                if(area[m][n] == 1) {
                    answer++;
                }
            }
        }

        
        output.write(String.valueOf(answer));
        input.close();
        output.close();
    }
}