/**
 *  문제 이름 : 스위치 켜고 끄기
 * 
 *  난 이  도 : 실버 4
 * 
 *  아이디어 : 남자일 경우 해당 스위치 index가 주어지면 그의 배수에 해당하는 스위치를 변경한다.
 *              여자일 경우 해당 스위치 index가 주어지면 
 *              스위치 index 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 스위치를 변경시킨다.
 *              무조건 홀수 있다.
 * 
 *  해    설 : 
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
 import java.util.StringTokenizer;
 
 class B1244 {
     public static void change_switch(int[] switch_array, int on_off, int index) {
         switch(on_off) {
             case 0 :
                 switch_array[index] = 1;
                 break;
             case 1 :
                 switch_array[index] = 0;
                 break;
         }
     }
 
     public static void man(int[] switch_array, int swich_index) {
         int temp_index = swich_index;
 
         while(temp_index < switch_array.length) {  
             int on_off = switch_array[temp_index];
 
             change_switch(switch_array, on_off, temp_index);
 
             temp_index += swich_index;
         }
     }
 
     public static void woman(int[] switch_array, int swich_index) {
         int back_index = swich_index-1;
         int front_index = swich_index + 1;

         int on_off = switch_array[swich_index];

         change_switch(switch_array, on_off, swich_index);
 
         while((back_index > 0 && front_index < switch_array.length) && switch_array[front_index] == switch_array[back_index]) {
            int back_on_off = switch_array[back_index];
            int front_on_off = switch_array[front_index];

            change_switch(switch_array, back_on_off, back_index);
            change_switch(switch_array, front_on_off, front_index);

            back_index--;
            front_index++;
         }
     }
 
     public static void main(String[] args) throws IOException {
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
 
         int swithch_num = Integer.parseInt(input.readLine());
 
         StringTokenizer token = new StringTokenizer(input.readLine());
 
         int switch_array[] = new int[swithch_num+1];
 
         for(int i =1; i <= swithch_num; i++) {
             switch_array[i] = Integer.parseInt(token.nextToken());
         }
 
         int people_TO = Integer.parseInt(input.readLine());
 
         for(int i =0; i< people_TO; i++) {
             token = new StringTokenizer(input.readLine());
 
             int gender = Integer.parseInt(token.nextToken());
             int switch_index = Integer.parseInt(token.nextToken());
 
             switch (gender) {
                 case 1 : 
                     man(switch_array, switch_index); // 문제 없음
                     break;
 
                 case 2 :
                     woman(switch_array, switch_index);
                     break;
             }
         }
 
         for(int j = 1; j <= swithch_num; j++) {
             output.write(String.valueOf(switch_array[j])+" ");

             if(j%20 == 0) {
                output.write("\n");
             }
         } 
         input.close();
         output.close();
     }
 }