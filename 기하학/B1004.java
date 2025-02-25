/**
 *  문제 이름 : 어린 왕자
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 주인공의 출발점과 도착점이 주어진다. 이때 행성게의 출입과 탈출의 횟수를 구하여라
 *              주인공 좌표 (x1, y1), (x2, y2)가 주어지고
 *              행성게의 좌표는 (x, y, r)이 주어진다.
 * 
 *  해    설 : 
 *              간단하다. 
 *              주인공의 좌표에서 행성게가 그 좌표를 감싸고 있으면 무조건 탈출해야하고
 *              만약 도착점이 행성게에 둘러싸여있다면 무조건 진입해야한다.
 *         
 *              즉 행성게의 중심과 주인공의 거리를 구한 뒤 반지름보다 작다면 탈출 또는 진입해야된다는 뜻
 * 
 *              하지만 출발점과 탈출점이 행성게에 둘러쌓여있다면 굳이 진입이나 탈출을 할 필요가 없다.
 *              그렇기 때문에 출발, 탈출점이 행성의 중심의 거리가 반지름보다 작다면 나갈 필요가 없기 때문에 정답 count를 셀 필요가 없다.
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

public class B1004 {
    public static void main(String argc[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        for(int i =0; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());
    
            // 출발점 (x1, y1), (x2, y2)
            int start_x1 = Integer.parseInt(token.nextToken());
            int start_y1 = Integer.parseInt(token.nextToken());
            int start_x2 = Integer.parseInt(token.nextToken());
            int start_y2 = Integer.parseInt(token.nextToken());
    
            // 행성 갯수
            int planet_num = Integer.parseInt(input.readLine());

            int answer = 0;

            for(int j = 0; j < planet_num; j++) {
                token = new StringTokenizer(input.readLine());

                int planet_x = Integer.parseInt(token.nextToken());
                int planet_y = Integer.parseInt(token.nextToken());
                int round_range = Integer.parseInt(token.nextToken());

                int dist_start_x1 = (int)Math.pow(start_x1-planet_x, 2);
                int dist_start_y1 = (int)Math.pow(start_y1-planet_y, 2);

                int dist_start_x2 = (int)Math.pow(start_x2-planet_x, 2);
                int dist_start_y2 = (int)Math.pow(start_y2-planet_y, 2);

                if(dist_start_x1 + dist_start_y1 < round_range*round_range) {
                    answer++;
                } else if(dist_start_x2 + dist_start_y2 < round_range * round_range) {
                    answer++;
                }


                // 이게 핵심
                if((dist_start_x1 + dist_start_y1 < round_range*round_range) && (dist_start_x2 + dist_start_y2 < round_range * round_range)) {
                    answer--;
                }

            }

            output.write(String.valueOf(answer) +"\n");
        }


        input.close();
        output.close();
    }
}
