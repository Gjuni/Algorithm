/**
 *  문제 이름 : 참외밭
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 참외의 갯수를 구하시오 (사실 상 면적 구하기 문제제)
 *            1: 동쪽, 2: 서쪽, 3: 남쪽, 4: 북쪽
 * 
 *  해    설 : 
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

public class B2477 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int fruits = Integer.parseInt(input.readLine());

        int height_arr[] = new int[7];
        int weight_arr[] = new int[7];
        
        int max_height_index = 0;
        int max_weight_index = 0;

        for(int i =0; i< 6; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int side = Integer.parseInt(token.nextToken());
            int lenght = Integer.parseInt(token.nextToken());

            if(side == 1 || side == 2) {
                height_arr[i] = lenght;
                
                if(max_height_index < height_arr[i]) {
                    max_height_index = i;
                }
            } else {
                weight_arr[i] = lenght;

                if(max_weight_index < weight_arr[i]) {
                    max_weight_index = i;
                }
            }
        }

        // min_wegith 값을 알고 싶으면 max_height 값을 이용
        // min_height 값을 알고 싶으면 max_weight 값을 이용

        int min_height = 0;
        int min_weight = 0;

        int max_height_index_minus = max_height_index -1;
        int max_height_index_plus = max_height_index + 1;

        if(max_height_index_minus == -1) {
            max_height_index_minus = 6;
        }

        if (max_height_index_plus == 7) {
            max_height_index_plus = 0;
        }

        int max_weight_index_minus = max_weight_index -1;
        int max_weight_index_plus = max_weight_index +1;

        if(max_weight_index_minus == -1) {
            max_weight_index_minus = 6;
        }

        if(max_weight_index_plus == 7) {
            max_weight_index_plus = 0;
        }

        min_height = height_arr[max_weight_index_minus] - height_arr[max_weight_index_plus];
        min_weight = weight_arr[max_height_index_minus] - weight_arr[max_height_index_plus];

        if(min_height < 0) {
            min_height *= -1;
        }

        if(min_weight < 0) {
            min_weight *= -1;
        }

        output.write(String.valueOf(height_arr[max_height_index]) + " "+ String.valueOf(weight_arr[max_weight_index])+"\n");
        output.write(String.valueOf(min_height) + " " + String.valueOf(min_weight)+"\n");

        int total_wide = height_arr[max_height_index] * weight_arr[max_weight_index] - min_height * min_weight;

        output.write(String.valueOf(total_wide * fruits));

        input.close();
        output.close();
    }
}
