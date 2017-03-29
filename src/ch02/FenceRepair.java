package ch02;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by chenbohua on 2017/3/29.
 * page76 PKU3253
 */
public class FenceRepair {
    public void solve(int[] arr){//solve with priority queue
        if(arr.length<2){
            System.out.println(arr[0]);
            return;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int sum=0;
        for(int a:arr)queue.add(a);
        while(queue.size()>1){
            int a=queue.remove();
            int b=queue.remove();
            int ab=a+b;
            sum+=ab;
            queue.add(ab);
        }
        System.out.println(sum);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++)arr[i]=in.nextInt();
        new FenceRepair().solve(arr);
    }
}
