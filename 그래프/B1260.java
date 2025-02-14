
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B1260 {
    static boolean visit[];
    static int[][] graph;
    static Queue<Integer> queue = new LinkedList<>();

    public static void addGraph(int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public static void DFS(int start, int vertex) {
        visit[start] = true; // 방문 처리
        System.out.print(start+ " ");
        
        for(int i = 1; i <= vertex; i++) {
            if(graph[start][i] == 1 && visit[i] == false) {
                DFS(i, vertex);
            }
        }
    }

    public static void BFS(int start, int vertex) {
        visit[start] = true;

        queue.add(start);

        while(!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for(int w = 1; w <= vertex; w++) {
                if(visit[w] == false && graph[v][w] == 1) {
                    visit[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int vertex = Integer.parseInt(token.nextToken());
        int edge = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(token.nextToken());

        graph = new int[vertex+1][vertex+1];

        for(int i = 0; i < edge ; i++) {
            token = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            addGraph(x, y);
        }

        visit = new boolean[vertex+1]; // 1이면 방문 (1부터 시작임)
        DFS(start, vertex);
        output.write("\n");
        output.flush();

        visit = new boolean[vertex+1]; // 1이면 방문 (1부터 시작임)

        BFS(start, vertex);
            


        // for(int i =1; i<= vertex; i++) {
        //     for(int j =1; j <= vertex; j++) {
        //         output.write(String.valueOf(graph[i][j])+" ");
        //     }
        //     output.write(String.valueOf("\n"));
        // }

        input.close();
        output.close();
    }
}
