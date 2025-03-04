/**
 *  문제 이름 : 균형잡힌 세상
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : ()와 []가 짝을 이루어야한다.
 * 
 *  해    설 : 
 *              "( [" 나왔을 시 stack에 push해주고
 *              ") ]" 나왔을 시 stack을 확인한다.
 *              
 *              만약 ) 일경우 ( 가 존재하면 결과를 true를 반환하고 
 *              ] 일 경우 괄호가 맞지 않기 때문에 결과를 false로 반환한다. []도 마찬가지로 진행한다.
 *              
 *              이때 내가 실수한 부분은 결과 값이 true인 것을 확인하면서 Stack이 비어있는지 동시에 확인했어야하는데
 *              Or 연산자를 써서 10%부분에서 계속 틀렸다.
 * 
 *              (result && Stack.isEmpty)
 *              
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

public class B4949 {
    public static boolean check(Stack<Character> stack, Character cmp_char) {
        if(stack.isEmpty()) {
            return false;
        } else {
            Character top_stack = stack.peek();

            if((top_stack == '(' && cmp_char == ')') || (top_stack == '[' && cmp_char == ']')) {
                stack.pop();
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean result = true;

        String string = input.readLine();

        while(!string.equals(".")) {
            result = true;

            Stack<Character> parentheses = new Stack<>();

            for(int i =0; i < string.length(); i++) {
                char cmp_char = string.charAt(i);

                if(cmp_char == '(' || cmp_char =='[') {
                    parentheses.add(cmp_char);
                } else if(cmp_char == ')' || cmp_char == ']') {
                    result = check(parentheses, cmp_char);
                }

                if(!result) {
                    break;
                }

            }


            if(result && parentheses.isEmpty()) {
                output.write("yes\n");
            } else {
                output.write("no\n");
            }

            string = input.readLine();
        }



        input.close();
        output.close();
    }
}
