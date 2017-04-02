package ch02;

import ds.EdgeV1;
import ds.GraphV1;
import ds.VertexV1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by chenbohua on 2017/4/2.
 * p96 of Programming Contest Challenge Book Chinese second Edition
 * Whether a graph can be drawn by two colors with nearby vertexes having different colors
 */
public class BinaryGraph {
    public static void main(String[] args){
        new BinaryGraph().preprocess();
    }
    public void preprocess(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        GraphV1<Vdata,Object> graph=new GraphV1<>(n);
        for(int i=0;i<n;i++)graph.vertexList.add(new VertexV1<>(new Vdata(i)));
        for(int i=0;i<k;i++){
            int from=in.nextInt();
            int to=in.nextInt();
            graph.edgeList.get(from).add(new EdgeV1<>(null,to));
            graph.edgeList.get(to).add(new EdgeV1<>(null,from));
        }
        solve(graph);
    }
    private class Vdata{
        boolean color=false;
        boolean visited=false;
        int index=0;
        boolean inqueue=false;
        Vdata(){}
        Vdata(int i){index=i;}
    }
    public void solve(GraphV1<Vdata,Object> graph){
        boolean judge=true;
        //int checked=0;
        //int n=graph.vertexList.size();
        LinkedList<VertexV1> queue=new LinkedList<>();
        //VertexV1 v1=graph.vertexList.get(0);
        //Vdata vdata=(Vdata)v1.getData();
        //vdata.color=true;
        //vdata.visited=true;
        //vdata.inqueue=true;
        boolean over=false;
        queue.addLast(graph.vertexList.get(0));//reference?
        while(!over){
            if(queue.isEmpty()){
                for(VertexV1<Vdata> ver:graph.vertexList){
                    if(!ver.getData().visited){
                        ver.getData().visited=true;
                        ver.getData().color=true;
                        ver.getData().inqueue=true;
                        queue.add(ver);
                        break;
                    }
                }
            }
            if(queue.isEmpty())break;
            VertexV1 v=queue.removeFirst();
            Vdata data=(Vdata)v.getData();
            boolean color=data.color;
            int index=data.index;
            ArrayList<EdgeV1<Object>> edgeV1s=graph.edgeList.get(index);
            ArrayList<VertexV1<Vdata>> vertexV1s=graph.vertexList;
            for(EdgeV1<Object> e:edgeV1s){
                int to=e.getTo();
                VertexV1<Vdata> vto=vertexV1s.get(to);
                boolean vtovisted=vto.getData().visited;
                boolean vtocolor=vto.getData().color;
                //boolean vtoinqueue=vto.getData().inqueue;
                if(!vtovisted){
                    vto.getData().visited=true;
                    vto.getData().color=!color;
                    vto.getData().inqueue=true;
                    queue.addLast(vto);
                }else if(vtocolor==color) {
                        judge = false;
                        over=true;
                        break;
                }
            }
        }
        System.out.println(judge);
    }
}