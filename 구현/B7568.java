/**
 *  문제 이름 : 덩치
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : 덩치 순위를 매길려고 한다.
 *              이때 weight와 height가 주어지는데 간략하게 w와 h라 하겠다.
 *              
 *              w1 > w2와 h1 > h2이라면 1번 사람이 압도적으로 크기 때문에 덩치가 더 크다고 말할 수 있다.
 *              다만 w1 > w2지만 h1 < h2라면 1번 사람이  몸무게는 더 나가지만  2번보다 키가 작기에 덩치로 비교는 불가능하다.
 *              그럴 경우에는 공동 순위로 매긴다.
 * 
 *  해    설 : 어렵게 생각했지만 
 *             브루트포스로 그냥 (나)와 (비교군) 들을 비교하면서
 *              나보다 크면 index값을 증가시켜 비교군들과 다 비교했으면
 *              rank에 내 순위를 기록하는 식으로 풀었다.
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

public class B7568 {
    public static void solve(int weight[], int height[], int rank[]) {
        
        for(int i =0; i< weight.length; i++) {
            int index = 1;

            for(int j = 0; j < weight.length; j++) {
                if(i == j) {
                    continue;
                }

                if(weight[i] < weight[j] && height[i] < height[j]) {
                    index++;
                }
            }

            rank[i] = index;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());
        int rank[] = new int[repeat_num];

        int weight[] = new int[repeat_num];
        int height[] = new int[repeat_num];

        for(int i =0; i< repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int w = Integer.parseInt(token.nextToken());
            int h = Integer.parseInt(token.nextToken());

            weight[i] = w;
            height[i] = h;
        }

        solve(weight, height, rank);

        for(int num : rank) {
            output.write(String.valueOf(num)+" ");
        }

        input.close();
        output.close();
    }
}
