/**
 *  문제 이름 : 참외밭
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 참외의 갯수를 구하시오 (사실 상 면적 구하기 문제제)
 *            1: 동쪽, 2: 서쪽, 3: 남쪽, 4: 북쪽
 * 
 *  해    설 : 
 *              width와 height가 존재할 때 
 *              작은 상자의 크기는 
 *          
 *              min_height = 가장 큰 width에서 index + 1, index -1의 길이를 구해서 빼주면 되고
 *              min_width = 가장 큰 height에서 index +1, index -1의 길이를 구해서 빼주면 됨 
 *              ** index -1은 (index +5)%6과 동일함 변이 총 6개니 나머지 6으로 나눠 index 범위를 넘지 않게 구할 수 있음
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

        int array[] = new int[6];
        int side_array[] = new int[6];
        
        int max_height = 0;
        int max_height_index = 0;
        int max_weight = 0;
        int max_weight_index = 0;

        for(int i =0; i< 6; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            side_array[i] = Integer.parseInt(token.nextToken());
            array[i] = Integer.parseInt(token.nextToken());

            if(side_array[i] == 1 || side_array[i] == 2) {                
                if(max_height < array[i]) {
                    max_height = array[i];
                    max_height_index = i;
                }
            } else {
                if(max_weight < array[i]) {
                    max_weight = array[i];
                    max_weight_index = i;
                }
            }
        }

        int min_weight = Math.abs(array[(max_height_index+1)%6] - array[(max_height_index+5)%6]);
        int min_height = Math.abs(array[(max_weight_index+1)%6] - array[(max_weight_index+5)%6]);

        int result = (max_height * max_weight) - (min_height * min_weight);

        output.write(String.valueOf(result*fruits));

        input.close();
        output.close();
    }
}
