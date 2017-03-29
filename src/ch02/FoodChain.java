package ch02;

import ds.DisjointSet;

import java.util.Scanner;

/**
 * Created by chenbohua on 2017/3/29.
 */
public class FoodChain {
    public static void main(String[] args){
        new FoodChain();
    }
    private DisjointSet set=null;
    private int count=0;
    private int n;
    private int k;
    int ia(int i){return 3*i;}
    int ib(int i){return 3*i+1;}
    int ic(int i){return 3*i+2;}
    FoodChain(){
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
                set.unionV2(ia(a),ia(b));
                set.unionV2(ib(a),ib(b));
                set.unionV2(ic(a),ic(b));
            }
            //return;
        }else{
            boolean invalid=
                    set.check(ia(a),ic(b))||set.check(ia(a),ia(b));
            if(invalid)count++;
            else{
                set.unionV2(ia(a),ib(b));
                set.unionV2(ib(a),ic(b));
                set.unionV2(ic(a),ia(b));
            }
        }
    }
}
