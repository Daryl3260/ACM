package ds;

import java.util.ArrayList;

/**
 * Created by chenbohua on 2017/4/2.
 * Graph by table
 */
public class GraphV1<T,E> {
    public ArrayList<VertexV1<T>> vertexList;
    public ArrayList<ArrayList<EdgeV1<E>>> edgeList;
    public GraphV1(){}
    public GraphV1(int n){
        vertexList=new ArrayList<>(n);
        edgeList=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            edgeList.add(new ArrayList<>());
        }
    }
}
