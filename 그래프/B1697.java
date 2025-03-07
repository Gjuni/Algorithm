
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int location;
    int depth;

    Pair (int location, int depth) {
        this.location = location;
        this.depth = depth;
    }
}

public class B1697 {
    static boolean[] visit = new boolean[100001];
    static Queue<Pair> q = new ArrayDeque<>();

    public static int BFS(int my_location, int sis_location) {
        int depth = 0;
        q.add(new Pair(my_location, depth));

        while(!q.isEmpty()) {
            Pair current = q.poll();
            int loc = current.location;
            int times = current.depth;
            
            if((loc < 0 || loc > 100000)) {
                continue;
            } else if(visit[loc]) {
                continue;
            }

            visit[loc] = true;

            if(loc == sis_location) {
                return times;
            }

            q.offer(new Pair(loc+1, times+1));
            q.offer(new Pair(loc-1, times+1));
            q.offer(new Pair(loc*2, times+1));
        }
        
        return 0;
    }   

    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int my_location = Integer.parseInt(token.nextToken());
        int sis_location = Integer.parseInt(token.nextToken());


        int result = BFS(my_location, sis_location);
        output.write(String.valueOf(result));

        input.close();
        output.close();
    }
}
