/**
 *  문제 이름 : 단지번호붙이기
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 정사각형 모양의 지도가 있다.
 *              인접한 1의 단지 면적을 구하고 단지 갯수를 구해서 출력하라.
 * 
 *  해    설 : 
 *              단지 전체 갯수는 Main루프를 돌며 계산이 가능하고
 *              단지 면적은 solve 재귀함수를 통해서 갯수를 구한 뒤 List에 추가해주었다.
 *              
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
import java.util.ArrayList;
import java.util.Collections;

public class B2667 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int n = 0;
    static int current_house_num;

    public static int solve(int[][] arr, int h, int w) {
        if((n > h && h >= 0) && (n > w && w >= 0)) {
            if(arr[h][w] == 1) {
                arr[h][w] = 0;
    
                solve(arr, h-1, w);
                solve(arr, h+1, w);
                solve(arr, h, w+1);
                solve(arr, h, w-1);
    
                current_house_num++;
            }
        }

        return current_house_num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(input.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {

            String string = input.readLine();

            for (int j = 0; j < string.length(); j++) {
                arr[i][j] = string.charAt(j)-'0';
            }

        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    current_house_num = 0;

                    current_house_num = solve(arr, i, j);

                    list.add(current_house_num);
                    
                    answer++;
                }
            }
        }

        output.write(String.valueOf(answer)+"\n");

        Collections.sort(list);

        for(int i : list) {
            output.write(String.valueOf(i)+"\n");
        }

        input.close();
        output.close();
    }
}
