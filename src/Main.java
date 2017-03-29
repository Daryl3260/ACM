import java.util.Scanner;

/**
 * Created by chenbohua on 2017/3/29.
 * page76 PKU3253
 */
public class Main {
    public static void main(String[] args){
        new Main();
    }
    private DisjointSet set=null;
    private int count=0;
    private int n;
    private int k;
    int ia(int i){return 3*i;}
    int ib(int i){return 3*i+1;}
    int ic(int i){return 3*i+2;}
    Main(){
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        k=in.nextInt();
        this.n=n;
        this.k=k;
        set=new DisjointSet(3*n);
        for(int i=0;i<k;i++){
            int d=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            check(d,a,b);
        }
        System.out.println(count);
    }
    private void check(int d,int a,int b){
        if(a>n||b>n){
            count++;
            return;
        }
        if(d==2&&a==b){
            count++;
            return;
        }
        if(d==1){
            boolean invalid=
                    set.check(ia(a),ib(b))||set.check(ia(a),ic(b));
            if(invalid)count++;
            else{
                set.union(ia(a),ia(b));
                set.union(ib(a),ib(b));
                set.union(ic(a),ic(b));
            }
            //return;
        }else{
            boolean invalid=
                    set.check(ia(a),ic(b))||set.check(ia(a),ia(b));
            if(invalid)count++;
            else{
                set.union(ia(a),ib(b));
                set.union(ib(a),ic(b));
                set.union(ic(a),ia(b));
            }
        }
    }
}

class DisjointSet {
    private int[] arr;
    //positive number names its parent node while absolute value of negative number presents height
    public DisjointSet(int n){
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=-1;
    }
    public void union(int a,int b){
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
    public int find(int a){
        int r=a;
        while(arr[r]>=0)r=arr[r];
        return r;
    }
    public boolean check(int a,int b){//check whether a and b are in the same set
        return find(a)==find(b);
    }
}