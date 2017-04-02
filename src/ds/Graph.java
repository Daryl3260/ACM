package ds;

/**
 * Created by chenbohua on 2017/4/2.
 */
public class Graph {
    public int[] vertex;
    public int[][] edge;
    public Graph(){}
    public Graph(int n){
        vertex=new int[n];
        for(int i=0;i<n;i++)vertex[i]=-1;
        edge=new int[n][];
        for(int i=0;i<n;i++) {
            edge[i] = new int[n];
            for(int j=0;j<n;j++)edge[i][j]=-1;
        }
    }
}
