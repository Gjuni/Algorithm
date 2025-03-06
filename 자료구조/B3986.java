/**
 *  문제 이름 : 좋은 단어
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 아치 형태로 사라지면 좋은단어이다.
 *              A는 A끼리 B는 B끼리 쌍을 짓는다.
 *              선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을 수 있다면
 *              좋은 단어.
 * 
 *  해    설 : Stack을 사용하여 
 *             Stack이 비어있다면 무조건 알파벳을 삽입한다.
 *             그렇지 않으면 Stack값을 peek 시켜 본 뒤 동일하면 pop시키고
 *              동일하지 않으면 push해서 넣는다.
 * 
 *              결과적으로 Stack이 비어있다면 true를 반환해 정답을 +1 해주고
 *              false라면 정답 Count를 시키지 않는다.
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
import java.util.Stack;

public class B3986 {

    // ABABAABABA
    public static boolean solved(String string) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < string.length(); i++) {
            char current_char = string.charAt(i);

            if(stack.isEmpty()) {
                stack.push(current_char);    
            } else {
                char temp_char = stack.peek(); // 확인만

                if(temp_char == current_char) {
                    stack.pop();
                } else {
                    stack.push(current_char);
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(input.readLine());

        int answer = 0;

        for (int i = 0; i < num; i++) {
            String string = input.readLine();

            if(solved(string)) {
                answer++;
            }
        }

        output.write(String.valueOf(answer));

        input.close();
        output.close();
    }
}
