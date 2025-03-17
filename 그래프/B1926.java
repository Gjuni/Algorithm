/**
 *  문제 이름 : 그림
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 0과 1로 이루어진 그래프가 주어진다.
 *              이때 1이 색이 칠해진 그림이고 0은 색이 칠해지지 않아졌다.
 *              
 *              그림의 갯수와 최대 넓이의 색이 칠해진 부분을 구하라.
 * 
 *  해    설 : 2가지를 고려해야한다.
 *             색이 칠해진 그림은 sovle함수에서 1의 갯수를 구하여 max_size 3항 연산을 통해서 구해주었고
 *             그림의 갯수는 Main에서 solve로 이동하는 수를 세서 구해주었다.
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

public class B1926 {
    static int wide_pic = 0;
    static int height;
    static int width;

    public static int solve (int[][] arr, int h, int w) {

        if((height > h && h >= 0) && (width > w && w >= 0)) {
            if(arr[h][w] == 1) {
                arr[h][w] = 0;
                solve(arr, h+1, w);
                solve(arr, h-1, w);
                solve(arr, h, w+1);
                solve(arr, h, w-1);

                wide_pic++;
            }
        }

        return wide_pic;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        height = Integer.parseInt(token.nextToken());
        width = Integer.parseInt(token.nextToken());

        int[][] arr = new int[height][width];

        for (int i = 0; i < height; i++) {
            token = new StringTokenizer(input.readLine());

            for (int j = 0; j < width; j++) {
                int num = Integer.parseInt(token.nextToken());

                arr[i][j] = num;
            }
        }

        int total_pic = 0;
        int max_pic_size = 0;
        int current_num = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(arr[i][j] == 1) {
                    wide_pic = 0;
                    
                    current_num = solve(arr, i, j);

                    max_pic_size = current_num > max_pic_size ? current_num : max_pic_size;

                    total_pic++;
                }
            }    
        }

        output.write(String.valueOf(total_pic)+"\n"+String.valueOf(max_pic_size));

        input.close();
        output.close();
    }
}
