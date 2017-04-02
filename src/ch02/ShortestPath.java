package ch02;

import ds.Graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by chenbohua on 2017/4/2.
 * p99 of Programming Contest Challenge Book Chinese second Edition
 */
public class ShortestPath {
    public static void main(String[] args){
        new ShortestPath().preprocess();
    }
    public void preprocess(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int start=in.nextInt();
        int end=in.nextInt();
        Graph g=new Graph(n);
        for(int i=0;i<k;i++){
            int from=in.nextInt();
            int to=in.nextInt();
            int value=in.nextInt();
            g.edge[from][to]=value;
            g.edge[to][from]=value;
        }
        solve(g,start,end);
    }
    public void solve(Graph g,int s,int e){
        LinkedList<Integer> queue=new LinkedList<>();
        g.vertex[s]=0;
        queue.addLast(s);
        int n=g.vertex.length;
        while(!queue.isEmpty()){
            int v=queue.removeFirst();
            for(int i=0;i<n;i++){
                if(v==i||g.edge[v][i]==-1)continue;
                int value=g.vertex[i];
                if(value==-1||value>g.vertex[v]+g.edge[v][i]){
                    g.vertex[i]=g.vertex[v]+g.edge[v][i];
                    queue.addLast(i);
                }
            }
        }
        System.out.println(g.vertex[e]);
    }
}
