/**
 *  문제 이름 : 스택 수열
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 1 ~ n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 *              스택에 PUSH하는 순서는 반드시 오름차순(1 2 3 4)으로 지키도록 한다.
 *              수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 PUSH와 POP 연산을 수행해야 하는지 알아낼 수 있다.
 *              이를 계산하는 프로그램을 작성하시오.
 * 
 *  해    설 : 어캐 맞춘거지...?
 * 
 *              암튼 최대한 설명해보자면
 *              
 *              1. 만들고자하는 수열을 배열에 집어넣는다.
 *              2. 그 후 stack에 들어갈 값과 배열의 값을 비교를 한다.
 *              3. 만약 stack에 들어갈 값이 배열의 값보다 작다면 stack에 계속 들어간다. (배열 안에 값이 4이고 stack값이 1이라면 1, 2 ,3, 4 이런식으로 삽입) 
 *              4. stack 값이 배열 값보다 크거나 같다면 비교를 시작한다.
 *                      4-1. stack값을 pop() 시켜 배열의 값과 비교를 한다.
 *                      4-2. stack값이 배열값과 동일하다면 pop()
 *                      4-3. stack값이 배열값과 다르다면 성립할 수 없는 수열이기에 NO를 출력한다.
 *              간단히 예를 들면
 *              원하는 수열 : 1 2 5 3 4  라고 하면
 *              stack에는 1 push -> 1 pop -> 2 push -> 2 pop -> 3,4,5 push -> 5 pop이 된다.
 *              이때 stack의 pop값은 4이고 배열에 저장된 값은 3이기 때문에 NO가 출력된다.
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
import java.util.ArrayList;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(input.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] cmp_array = new int[num];

        for(int i = 0; i< num; i++) {
            int current = Integer.parseInt(input.readLine());

            cmp_array[i] = current;
        }

        ArrayList<String> list = new ArrayList<>();

        int index = 0;
        int stack_num = 0;
        boolean check = false;

        while(true) {   
            int temp = cmp_array[index];
            
            if(temp > stack_num) {
                stack.add(++stack_num);
                list.add("+");
            } else if(temp <= stack_num) {
                int temp_stack_num = stack.pop();

                if(temp == temp_stack_num) {
                    list.add("-");
                    index++;
                } else if(temp != temp_stack_num) {
                    check = true;
                    break;
                }
            }

            if(index == num) {
                break;
            }
        }

        if(check) {
            output.write("NO");
        } else {
            for(String string : list) {
                output.write(string+"\n");  
            }
        }
 
        input.close();
        output.close();
    }
}
