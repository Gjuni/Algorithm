/**
 *  문제 이름 : 케빈 베이컨의 6단계 법칙
 * 
 *  난 이  도 : 실버 1
 * 
 *  아이디어 : 
 *              케빈 베이컨의 6단계 세계에서는 모든 사람이 6단계 이내에서 서로 아는 사람으로 연결 될 수 있다.
 *              이때 최소의 깊이로 모든 사람에게 닳을 수 있는 사람을 구하라
 *              만약 동일한 깊이라면 번호가 더 적은 사람을 출력하라
 * 
 *  해    설 : 
 *              Level Order BFS 방식을 사용해야한다.
 * 
 *              동일한 깊이 일 경우 그 Depth를 더해줘야한다.
 *              난 그것을 Queue의 크기로 선정하였다. 
 *              현재 깊이의 Queue 크기를 구한 후 for 문으로 해당 동알힌 깊이의 노드들을 전부 꺼내주고
 *              다시 Queue의 크기를 재서 그 다음 깊이의 노드들의 깊이를 더해서 정확한 값을 유추하게 만들었다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

public class B1389 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int graph[][];
    static boolean visit[];
    static int node;
    static int edge;

    static int answer_node;
    static int answer_Depth = Integer.MAX_VALUE;


    public static int BFS(int n) {
        int temp_answer = 0;
        int depth = 1;

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(n);
        visit[n] = true;


        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int h = 0; h < size; h++) {
                int temp_node = queue.poll();

                for (int i = 1; i < graph[temp_node].length; i++) {
                   if(graph[temp_node][i] == 1 && visit[i] == false) {
                        queue.add(i);
                        visit[i] = true;
                        temp_answer += depth;
                    }
                }
            }

            depth++;
        }

        return temp_answer;
    }

    public static void main(String argc[]) throws IOException {
        StringTokenizer token = new StringTokenizer(input.readLine());

        node = Integer.parseInt(token.nextToken());
        edge = Integer.parseInt(token.nextToken());

        graph = new int[node+1][node+1];
        visit = new boolean[node+1];

        for (int i = 0; i < edge; i++) {
            token = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i <= node; i++) {
            int temp_answer = 0;

            temp_answer = BFS(i);

            if(temp_answer != answer_Depth) {
                if(temp_answer < answer_Depth) {
                    answer_Depth = temp_answer;
                    answer_node = i;
                }
            }            

            visit = new boolean[node+1];
        }

        output.write(String.valueOf(answer_node));

        input.close();
        output.close();
    }
}
