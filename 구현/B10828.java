import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


class _Stack {
    private ArrayList<Integer> array = new ArrayList<Integer>();

    public _Stack() {
        this.array = new ArrayList<>();
    }

    public void push(int data) {
        array.add(data);
    }
    
    public int pop() {
        if(array.isEmpty()) {
            return -1;
        } else {
            int index = array.size() -1; // top index\
            int remove_num = array.remove(index);

            return remove_num;
        }
    }

    public int size() {
        return array.size();
    }

    public int empty() {
        if(array.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int top() {
        if(array.isEmpty()) {
            return -1;
        } else {
            int index = array.size()-1;
            return array.get(index);
        }
    }
};

public class B10828 {
 public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    _Stack stack = new _Stack();

    int repeat_num = Integer.parseInt(input.readLine());

    for(int i =0; i< repeat_num; i++) {
        StringTokenizer token = new StringTokenizer(input.readLine());

        String commend = token.nextToken();

        switch (commend) {
            case "pop" :
                output.write(String.valueOf(stack.pop())+"\n");
                break;
            case "size" :
                output.write(String.valueOf(stack.size())+"\n");
                break;
            case "empty" :
                output.write(String.valueOf(stack.empty())+"\n");
                break;
            case "top" :
                output.write(String.valueOf(stack.top())+"\n");
                break;
            default:
                int data = Integer.parseInt(token.nextToken());
                stack.push(data);
        }
    }
    
    output.close();
    input.close();
 }
}