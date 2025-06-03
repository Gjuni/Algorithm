/**
 *  문제 이름 : 사탕 게임
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              가장 처음에 N * N 크기의 사탕을 채워 놓는다.
 *              사탕의 색은 모두 같지 않을 수도 있다. 상근이는 색이 다른 인접한 두 칸을 고른다.
 *              그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
 *              이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분을 고른 다음 그 사탕을 모두 먹는다.
 *      
 *              사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.             
 * 
 *  해    설 : 
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;

public class B3085 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static char arr[][];
    static int answer = 1;
    static int arr_size;

    public static void swap (int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp; 
    }

    public static void search() {
        for (int i = 0; i < arr_size; i++) {
            int curr_count = 1;

            for (int j = 0; j < arr_size-1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    curr_count ++;
                    answer = Math.max(answer, curr_count);
                } else {
                    curr_count = 1;
                }
            }
        }


        for (int i = 0; i < arr_size; i++) {
            int curr_count = 1;

            for (int j = 0; j < arr_size-1; j++) {
                if(arr[j][i] == arr[j+1][i]) {
                    curr_count ++;
                    answer = Math.max(answer, curr_count);
                } else {
                    curr_count = 1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        arr_size = Integer.parseInt(input.readLine());

        arr = new char[arr_size][arr_size];

        for(int i = 0; i < arr_size; i++) {
            String string = input.readLine();

            for (int j = 0; j < arr_size; j++) {
                arr[i][j] = string.charAt(j);
            }
        }

        for (int j = 0; j < arr_size; j++) {
            for (int i = 0; i < arr_size-1; i++) {
                swap(i+1, j, i, j);
                search();
                swap(i, j, i+1, j);
            }
        }

        for (int i = 0; i < arr_size; i++) {
            for (int j = 0; j < arr_size-1; j++) {
                swap(i, j+1, i, j);
                search();
                swap(i, j, i, j+1);
            }
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}