/**
 *  문제 이름 : 덱
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 덱 구현
 *              push_front : 앞에 삽입
 *              push_back : 뒤에 삽입
 *              pop_front : 앞에서 pop, 덱이 비어있다면 -1 return
 *              pop_back : 뒤에서 pop, 덱이 비어있다면 -1 return
 *              size : 덱의 사이즈를 return
 *              empty : 덱이 비어있으면 1, 아니면 0
 *              front : 맨 앞에 값 return, 없다면 -1을 return 
 *              back : 덱 맨 뒤에 값 return, 없다면 -1을 return
 * 
 *  해    설 : 
 *               덱의 경우 큐와 다르게 앞과 뒤에 삽입이 가능하다.
 *               push와 pop시 모두 시간 복잡도는 O(1)이며
 *               탐색 시 O(n)이 들어간다.
 * 
 *               자바의 경우 ArrayDeque 이 존재한다.
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

class _Deque {
    static ArrayDeque<Integer> deck;

    public _Deque() {
        this.deck = new ArrayDeque<>();
    }

    public static int empty() {
        if(deck.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void push_back(int num) {
        deck.offerLast(num);
    }

    public static void push_front(int num) {
        deck.offerFirst(num);
    }

    public static int pop_back() {
        if(_Deque.empty() == 1) {
            return -1;
        }

        return deck.pollLast();
    }

    public static int pop_front() {
        if(_Deque.empty() == 1) {
            return -1;
        }
        return deck.pollFirst();
    }

    public static int size() {
        return deck.size();
    }

    public static int front() {
        if(_Deque.empty() == 1) {
            return -1;
        }
        return deck.peekFirst();
    }

    public static int back() {
        if(_Deque.empty() == 1) {
            return -1;
        }
        return deck.peekLast();
    }
}


public class B10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        _Deque deck = new _Deque();

        for(int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            String commend = token.nextToken();

            switch (commend) {
                case "push_back":
                    int num = Integer.parseInt(token.nextToken());

                    deck.push_back(num);    
                    break;
                case "push_front":
                    num = Integer.parseInt(token.nextToken());

                    deck.push_front(num); 
                    break;
                case "pop_front":
                    int answer = deck.pop_front();
                    output.write(String.valueOf(answer)+"\n");
                    break;
                case "pop_back":
                    answer = deck.pop_back();
                    output.write(String.valueOf(answer)+"\n");
                    break;
                case "front":
                    answer = deck.front();
                    output.write(String.valueOf(answer)+"\n");
                    break;
                case "back":
                    answer = deck.back();
                    output.write(String.valueOf(answer)+"\n");
                    break;
                case "size":
                    answer = deck.size();
                    output.write(String.valueOf(answer)+"\n");
                    break;
                case "empty":
                    answer = deck.empty();
                    output.write(String.valueOf(answer)+"\n");
                    break;
            }
        }
        
        input.close();
        output.close();
    }
}
