/**
 *  문제 이름 : 바이러스
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 
 *              1번 컴퓨터가 바이러스에 걸렸다.
 *              인접한 모든 컴퓨터가 바이러스에 전염된다.
 *              
 *              1번 컴퓨터를 제외한 바이러스에 옮겨진 컴퓨터의 갯수를 구하시오.
 * 
 *  해    설 : 
 *              전형적인 BFS 문제
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

public class B2606 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int graph[][];
    static boolean visit[];
    static int answer = 0;


    public static int BFS(int one) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        visit[one] = true;

        queue.add(one);

        while(!(queue.isEmpty())) {
            int curr_node = queue.poll(); // queue 맨 앞 요소 pop

            // 현재 노드의 길이 만큼 배열 탐색
            for(int i = 1; i < graph[curr_node].length; i++) {
                int next = graph[curr_node][i]; 

                // 아직 방문하지 않은 node라면?
                if(next == 1 && visit[i] == false) {
                    visit[i] = true;

                    queue.add(i);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int node = Integer.parseInt(input.readLine());

        // 초기화
        graph = new int[node+1][node+1]; 
        visit = new boolean[node+1];

        int repeat_num = Integer.parseInt(input.readLine());

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            // 그래프에 삽입
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            
            // 1이라면 인접한 노드임.
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        output.write(String.valueOf(BFS(1)));

        input.close();
        output.close();
    }
}
