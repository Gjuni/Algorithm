/**
 *  문제 이름 : 체스판 다시 칠하기
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 
 *             체스판을 다시 칠하는 칸의 갯수가 최소가 되는 칸의 갯수를 구하라
 * 
 *  해    설 : 
 *             브루트포스..
 *              
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

public class B1018 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static String black_arr[] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
    };

    static String white_arr[] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
    };


    public static int answer(String arr[], int h, int w) {
        
        int index_h = h-8+1;
        int index_w = w-8+1;

        int black_answer = Integer.MAX_VALUE;
        int white_answer = Integer.MAX_VALUE;

        for (int i = 0; i < index_h; i++) {
            for (int j = 0; j < index_w; j++) {
                int temp_black = 0;
                int temp_white = 0;

                
                for(int temp_h = i; temp_h < 8 + i; temp_h++) {
                    String black = black_arr[temp_h - i];
                    String white = white_arr[temp_h - i];
                    String curr_boardLine = arr[temp_h];

                    for(int temp_w = j; temp_w < 8 + j; temp_w++) {
                        char compare_black = black.charAt(temp_w - j);
                        char compare_white = white.charAt(temp_w - j);
                        char curr_board = curr_boardLine.charAt(temp_w);

                        if(curr_board != compare_black) {
                            temp_black ++;
                        }

                        if(curr_board != compare_white) {
                            temp_white ++;
                        }
                    }
                }

                black_answer = Math.min(temp_black, black_answer);
                white_answer = Math.min(temp_white, white_answer);
            }
        }

        return Math.min(black_answer, white_answer);
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer token = new StringTokenizer(input.readLine());

        int h = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());

        String arr[] = new String[h];

        for (int i = 0; i < h; i++) {

            String current = input.readLine();

            arr[i] = current;
        }

        output.write(String.valueOf(answer(arr, h, w)));

        input.close();
        output.close();
    }
}