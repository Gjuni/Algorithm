/**
 *  문제 이름 : 트리의 부모 찾기
 * 
 *  난 이  도 : 실버 2
 * 
 *  아이디어 : Tree 구현현
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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Tree {
    Node root;

    public Tree(int rootData) {
        root = new Node(rootData);
    }
}

class Node {
    int data;
    List<Node> child;

    public Node(int data) {
        this.data = data;
        this.child = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.child.add(child);
    }
}


public class B117255 {
    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int node_count = Integer.parseInt(input.readLine());
        Tree tree = new Tree(1);

        for(int i =0; i< node_count; i++) {
            StringTokenizer node = new StringTokenizer(input.readLine());

            int node_1 = Integer.parseInt(node.nextToken());
            int node_2 = Integer.parseInt(node.nextToken());


            
        }

        input.close();
        output.close();
    }
}
