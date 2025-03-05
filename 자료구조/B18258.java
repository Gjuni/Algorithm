/**
 *  문제 이름 : 큐 2
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 일반적인 큐 구현
 * 
 *  해    설 : 큐를 구현하려했지만 덱을 사용함
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
 import java.util.ArrayDeque;
 import java.util.StringTokenizer;

class _Queue {
    ArrayDeque<Integer> q;

    public _Queue() {
        this.q = new ArrayDeque<>();
    }


    public int empty() {
        if(q.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void push(int data) {
        q.offer(data);
    }

    public int pop() {
        if(empty() == 1) {
            return -1;
        } else {
            return q.poll();
        }
    }

    public int _size() {
        return q.size();
    }

    public int front() {
        if(empty() == 1) {
            return -1;
        } else {
            return q.peek();
        }
    }

    public int back() {
        if(empty() == 1) {
            return -1;
        } else {
            return q.peekLast();
        }
    }
}


public class B18258 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());
        _Queue q = new _Queue();

        for(int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String commend = token.nextToken();
            int num = 0;

            switch (commend) {
                case "push":
                    num = Integer.parseInt(token.nextToken());
                    q.push(num);
                    break;

                case "pop":
                    int result = q.pop();
                    output.write(String.valueOf(result)+"\n");
                    break;

                case "front":
                    result = q.front();
                    output.write(String.valueOf(result)+"\n");
                    break;

                case "back" :
                    result = q.back();
                    output.write(String.valueOf(result)+"\n");
                    break;

                case "size" :
                    result = q._size();
                    output.write(String.valueOf(result)+"\n");
                    break;

                case "empty" :
                    result = q.empty();
                    output.write(String.valueOf(result)+"\n");
                    break;
            }
        }

        input.close();
        output.close();
    }
}
