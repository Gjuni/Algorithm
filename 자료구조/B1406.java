/**
 *  문제 이름 : 에디터
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : 
 *              L : 커서를 왼쪽으로 한칸 옮김 (커서가 문장의 맨 앞이면 무시)
 *              D : 커서를 오른쪽으로 한칸 옮김 (커서가 문장의 맨 뒤면 무시)
 *              B : 커서 왼쪽에 있는 문자를 삭제 (커서가 문장의 맨 앞이면 무시됨)
 *                  삭제로 인해 커서는 한칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로
 *              P $ : $라는 문자를 커서 왼쪽에 추가가
 * 
 *              명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치치
 * 
 *  해    설 : Iterator에 대한 개념 지식이 필요했다.
 * 
 *             1. Iterator는 새로운 자식 클래스를 참조하는게 아니라 기존에 있던 list값을 참조하게 만든다.
 *              -> 즉 C언어로 따지면 포인터 개념인 셈
 *             2. Iterator 초기값은 맨 앞에 있는 값을 참조하게 된다.
 *             https://javanitto.tistory.com/10
 * 
 *             
 *             위의 문제의 경우 Stack이나 LinkedList으로 풀 수 있는데 LinkedList 공부를 위해 LinkedList로 풀었다.
 *             또한 hasNext와 previous를 통해 앞 뒤 값이 있는지 존재 유무 확인 후 넘어가게 설계하였다.
 * 
 *              특히 remove에서 다음 값을 그 전값을 참조 하는지 그 앞 값을 참조하는지 몰랐지만 커서 기준으로 설명하자면
 *          
 *              A B C| D 가 있을 떄 커서는 C에 존재한다. 그리고 C를 지우면 다음에는 B를 지울 수 있는 것 처럼 B가 다음 지정된 값으로 넘어가게 된다.
 * 
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
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class B1406 {
    public static void solve(ListIterator<Character> list, int repeat_num, BufferedReader input) throws IOException {
        while(list.hasNext()) {
            list.next();
        }

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String commend = token.nextToken();

            switch (commend) {
                case "L":
                    if(list.hasPrevious()) {
                        list.previous();
                    }
                    break;
                case "D":   
                    if(list.hasNext()) {
                        list.next();
                    }
                    break;
                case "B":
                    if(list.hasPrevious()) {
                        list.previous();
                        list.remove();
                    }
                    break;
                case "P":
                    String add = token.nextToken();
                    char convert = add.charAt(0);

                    list.add(convert);
                    break;
            }
            
        }
    }
     public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String string = input.readLine();

        LinkedList<Character> list = new LinkedList<>();
        
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator(); // linked list자체가 header 주소를 가지고 있어야되기 떄문에

        int repeat_num = Integer.parseInt(input.readLine());

        solve(iterator, repeat_num, input);

        for(char temp : list) {
            output.write(temp);
        }

        input.close();
        output.close();
    }
}
