package ds;

/**
 * Created by chenbohua on 2017/3/29.
 */
public class DisjointSet {
    private int[] arr;
    //positive number names its parent node while absolute value of negative number presents height
    public DisjointSet(int n){
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=-1;
    }
    public void union(int a,int b){//union by rank, roughly height
        int r1=find(a);
        int r2=find(b);
        if(r1==r2)return;
        else{
            int h1=-arr[r1];
            int h2=-arr[r2];
            if(h1<h2)
                arr[r1]=r2;
            else if(h1>h2)
                arr[r2]=r1;
            else{
                arr[r1]=r2;
                arr[r2]--;
            }
        }
    }
    public void unionV2(int a,int b){//union by size
        int r1=find(a);
        int r2=find(b);
        if(r1!=r2){
            int s1=-arr[r1];
            int s2=-arr[r2];
            if(s1<=s2){
                arr[r1]=r2;
                arr[r2]=-(s1+s2);
            }
            else {
                arr[r2]=r1;
                arr[r1]=-(s1+s2);
            }
        }
    }
    public int find(int a){
        /*
        int r=a;
        while(arr[r]>=0)r=arr[r];
        return r;*/
        if(arr[a]<0)return a;
        else{
            int root=find(arr[a]);
            arr[a]=root;
            return root;
        }
    }
    public boolean check(int a,int b){//check whether a and b are in the same set
        return find(a)==find(b);
    }
}
