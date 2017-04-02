package ds;

/**
 * Created by chenbohua on 2017/4/2.
 */
public class EdgeV1<T> {
    private T data=null;
    private int to=-1;
    public EdgeV1(){}
    public EdgeV1(T data,int to){
        this.data=data;
        this.to=to;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
