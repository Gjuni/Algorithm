/**
 *  문제 이름 : 회의실 배정
 * 
 *  난 이  도 : 골드 5
 * 
 *  아이디어 : 
 *              최대로 배정 가능한 회의 갯수를 구하여라
 *              전형적인 회의실 배정 문제
 * 
 *  해    설 : 그리디 중에서도 Activity Selection을 사용하였다.
 * 
 *              가장 빨리 끝나는 회의를 기준으로 정렬해야한다.
 *              즉 end값이 작은 것부터 정렬한 후 start도 가장 작은 순으로 정렬했다. (end가 동일할 때 회의 시간이 긴 순으로 정렬을 먼저했다.)
 *              
 *              class를 선언하여 end와 start를 받아 Comparable compareTo를 사용하였다.
 *              우선순위 큐가 알아서 정렬을 해주기 때문이다.
 *          
 *              그래서 첫 회의 시간은 반드시 포함한다. 가장 빨리 끝나는 회의이기 때문이다.
 *          
 *              그 후 다음 회의를 pop한다. 
 *              현재 진행 중인 회의의 끝나는 시간(end)이 다음 회의의 시작 시간(compare_start) 크다면
 *              ( end > compare_start ) : 배정에 실패한다. 겹치기 때문
 * 
 *              현재 진행 중인 회의의 끝나는 시간(end)가 다음 회의의 시작 시간(compare_start) 보다 작다면
 *              ( end < compare_start ) : 배정에 성공하고 
 *                                        start와 end를 compare_start와 compare_end로 갱신해준다.
 *                                        그리고 answer를 증가 시켜준다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;

class TimeLine implements Comparable<TimeLine>{
    int start;
    int end;

    public TimeLine(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TimeLine time) {
        if (this.end == time.end) {
            return this.start - time.start;
        }

        return this.end - time.end;
    }
}

 public class B1931 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solve(PriorityQueue<TimeLine> list) throws IOException{
        int answer = 0;

        TimeLine first_temp = list.poll();

        int start = first_temp.start;
        int end = first_temp.end;
        answer++;

        while(!list.isEmpty()) {
            TimeLine value = list.poll();

            int compare_start = value.start;
            int compare_end = value.end; // null point exception

            if(end <= compare_start) {
                end = compare_end;
                start = compare_start;

                answer++;
            }
        }

        return answer;
    }

     public static void main(String[] args) throws IOException{
         int num = Integer.parseInt(input.readLine());

         PriorityQueue<TimeLine> list = new PriorityQueue<>();

         for (int i = 0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            list.add(new TimeLine(start, end));
         }

        //  for(TimeLine line : list) {
        //     output.write(String.valueOf(line.start) + " "+ String.valueOf(line.end)+"\n");
        //  }

         output.write(String.valueOf(solve(list)));

         input.close();
         output.close();
     }
 }